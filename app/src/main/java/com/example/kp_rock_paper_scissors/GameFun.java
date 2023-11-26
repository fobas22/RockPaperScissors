package com.example.kp_rock_paper_scissors;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.io.Serializable;

public class GameFun implements Serializable {
    private static GameFun instance;
    private final Web3j web3j;
    private final Credentials credentials;
    private final ContractGasProvider gasProvider;
    private RockPaperScissors contract;
    private String contractAddress;
    private BigInteger player_Choice;
    private String weiValue_full;

    private GameFun(String privateKey) {
        gasProvider = new StaticGasProvider(
                BigInteger.valueOf(20_000_000_000L),
                BigInteger.valueOf(6_721_975));
        web3j = Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
        credentials = Credentials.create(privateKey);
    }

    public static GameFun getInstance(String privateKey) {
        if (instance == null) {
            instance = new GameFun(privateKey);
        }
        return instance;
    }

    public static GameFun getInstance() {
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public boolean deploy_contract(){
        if (contract == null){
            try {
                // Развертывание контракта (асинхронно)
                RemoteCall<RockPaperScissors> deployCall = RockPaperScissors.deploy(web3j, credentials, gasProvider);
                CompletableFuture<RockPaperScissors> futureContract = deployCall.sendAsync();

                // Добавляем обработчик завершения операции
                futureContract.thenApply(contract -> {
                    contractAddress = contract.getContractAddress();
                    return true;
                }).exceptionally(throwable -> {
                            return false;
                        }
                );
            } catch (Exception e) {
                System.out.println("Error deploying contract: " + e.getMessage());

                return false;
            }
            return true;
        }
        else {
            return false;
        }

    }

    public String get_player1(){
        String aaa;
        try {
            aaa = contract.player1().sendAsync().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return aaa;
    }
    public String get_player2(){
        String aaa;
        try {
            aaa = contract.player2().sendAsync().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return aaa;
    }



    public BigInteger get_player1_Choice(){
        BigInteger aaa;
        try {
            aaa = contract.player1Choice().sendAsync().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return aaa;
    }
    public BigInteger get_player2_Choice(){
        BigInteger aaa;
        try {
            aaa = contract.player2Choice().sendAsync().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return aaa;
    }
    public void register(BigInteger weiValue){
        weiValue_full =  weiValue.toString();
        RemoteFunctionCall<TransactionReceipt> registerTx = contract.register(weiValue); // Вызов метода регистрации
        try {
            TransactionReceipt receipt = registerTx.send(); // Отправка транзакции и получение результата
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void make_Choice(BigInteger choice){
        // Вызов метода makeChoice с передачей значения choice
        //RemoteFunctionCall<TransactionReceipt> makeChoiceTx = contract.makeChoice(choice);
// Отправка транзакции и получение результата
        //CompletableFuture<TransactionReceipt> receipt = makeChoiceTx.sendAsync();
        player_Choice = choice;
        //player_Choice = BigInteger.ONE;
    }

    public String get_add_con(){
        return contractAddress;
    }

    public BigInteger get_Choice(){
        return player_Choice;
    }
    public boolean isBigInteger(String str) {
        try {
            new BigInteger(str);
            return true; // Строка может быть успешно преобразована в BigInteger
        } catch (NumberFormatException e) {
            return false; // Строка не является числовым значением типа BigInteger
        }
    }
    public boolean isValidPrivateKey(String privateKey) {
        int aaa = privateKey.length();
        if (privateKey == null || privateKey.isEmpty()) {
            return false; // приватный ключ null или пустая строка
        }
        if (privateKey.length() != 64) {
            return false; // приватный ключ имеет неправильную длину
        }
        if (!privateKey.matches("[0-9A-Fa-f]+")) {
            return false; // приватный ключ содержит недопустимые символы
        }

        return true; // приватный ключ прошел проверку
    }

    public void load(String contractAddress){
        contract = RockPaperScissors.load(
                contractAddress,
                web3j,
                credentials,
                gasProvider);
    }

    public String get_weiValue_full(){
        return weiValue_full;
    }

    public void fin_g(){
        contract.finishGame().sendAsync();
    }

}
