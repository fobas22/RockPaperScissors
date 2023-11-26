package com.example.kp_rock_paper_scissors;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class RockPaperScissors extends Contract {
    public static final String BINARY = "608060405234801561000f575f80fd5b50610d278061001d5f395ff3fe60806040526004361061007a575f3560e01c80639fecb69f1161004d5780639fecb69f14610104578063d24257c01461011a578063d30895e414610144578063d8b1f2191461016e5761007a565b80630ce6e6801461007e5780631aa3a008146100a857806359a5f12d146100b25780635bc565fb146100dc575b5f80fd5b348015610089575f80fd5b50610092610198565b60405161009f91906108ba565b60405180910390f35b6100b061019e565b005b3480156100bd575f80fd5b506100c66103b5565b6040516100d39190610912565b60405180910390f35b3480156100e7575f80fd5b5061010260048036038101906100fd9190610959565b6103da565b005b34801561010f575f80fd5b50610118610578565b005b348015610125575f80fd5b5061012e610873565b60405161013b91906108ba565b60405180910390f35b34801561014f575f80fd5b50610158610879565b6040516101659190610912565b60405180910390f35b348015610179575f80fd5b5061018261089c565b60405161018f91906108ba565b60405180910390f35b60035481565b5f73ffffffffffffffffffffffffffffffffffffffff165f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061024357505f73ffffffffffffffffffffffffffffffffffffffff1660015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16145b610282576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161027990610a04565b60405180910390fd5b5f34116102c4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016102bb90610a92565b60405180910390fd5b5f73ffffffffffffffffffffffffffffffffffffffff165f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff160361035a57335f806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061039b565b3360015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b3460045f8282546103ac9190610add565b92505081905550565b60015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16148061047f575060015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b6104be576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104b590610b80565b60405180910390fd5b600181101580156104d0575060038111155b61050f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161050690610be8565b60405180910390fd5b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff160361056d5780600281905550610575565b806003819055505b50565b5f60025411801561058a57505f600354115b6105c9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105c090610c76565b60405180910390fd5b600354600254036106bd575f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc600260045461061c9190610cc1565b90811502906040515f60405180830381858888f19350505050158015610644573d5f803e3d5ffd5b5060015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc600260045461068f9190610cc1565b90811502906040515f60405180830381858888f193505050501580156106b7573d5f803e3d5ffd5b506107dd565b60016002541480156106d157506002600354145b806106ea5750600280541480156106e9575060038054145b5b806107055750600360025414801561070457506001600354145b5b15610774575f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc60045490811502906040515f60405180830381858888f1935050505015801561076e573d5f803e3d5ffd5b506107dc565b60015f9054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc60045490811502906040515f60405180830381858888f193505050501580156107da573d5f803e3d5ffd5b505b5b5f805f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505f60015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505f6004819055505f6002819055505f600381905550565b60045481565b5f8054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b5f819050919050565b6108b4816108a2565b82525050565b5f6020820190506108cd5f8301846108ab565b92915050565b5f73ffffffffffffffffffffffffffffffffffffffff82169050919050565b5f6108fc826108d3565b9050919050565b61090c816108f2565b82525050565b5f6020820190506109255f830184610903565b92915050565b5f80fd5b610938816108a2565b8114610942575f80fd5b50565b5f813590506109538161092f565b92915050565b5f6020828403121561096e5761096d61092b565b5b5f61097b84828501610945565b91505092915050565b5f82825260208201905092915050565b7f426f746820706c61796572732061726520616c726561647920726567697374655f8201527f7265640000000000000000000000000000000000000000000000000000000000602082015250565b5f6109ee602383610984565b91506109f982610994565b604082019050919050565b5f6020820190508181035f830152610a1b816109e2565b9050919050565b7f42657420616d6f756e742073686f756c642062652067726561746572207468615f8201527f6e20300000000000000000000000000000000000000000000000000000000000602082015250565b5f610a7c602383610984565b9150610a8782610a22565b604082019050919050565b5f6020820190508181035f830152610aa981610a70565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610ae7826108a2565b9150610af2836108a2565b9250828201905080821115610b0a57610b09610ab0565b5b92915050565b7f4f6e6c79207265676973746572656420706c61796572732063616e206d616b655f8201527f20612063686f6963650000000000000000000000000000000000000000000000602082015250565b5f610b6a602983610984565b9150610b7582610b10565b604082019050919050565b5f6020820190508181035f830152610b9781610b5e565b9050919050565b7f496e76616c69642063686f6963650000000000000000000000000000000000005f82015250565b5f610bd2600e83610984565b9150610bdd82610b9e565b602082019050919050565b5f6020820190508181035f830152610bff81610bc6565b9050919050565b7f426f746820706c61796572732073686f756c64206d616b6520612063686f69635f8201527f6500000000000000000000000000000000000000000000000000000000000000602082015250565b5f610c60602183610984565b9150610c6b82610c06565b604082019050919050565b5f6020820190508181035f830152610c8d81610c54565b9050919050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601260045260245ffd5b5f610ccb826108a2565b9150610cd6836108a2565b925082610ce657610ce5610c94565b5b82820490509291505056fea2646970667358221220c609da9d07f6cfbdef04603564026912d3782d7e9d3c0c2025e9f15f3ed0697a64736f6c63430008170033";

    public static final String FUNC_BETAMOUNT = "betAmount";

    public static final String FUNC_FINISHGAME = "finishGame";

    public static final String FUNC_MAKECHOICE = "makeChoice";

    public static final String FUNC_PLAYER1 = "player1";

    public static final String FUNC_PLAYER1CHOICE = "player1Choice";

    public static final String FUNC_PLAYER2 = "player2";

    public static final String FUNC_PLAYER2CHOICE = "player2Choice";

    public static final String FUNC_REGISTER = "register";

    @Deprecated
    protected RockPaperScissors(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RockPaperScissors(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RockPaperScissors(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RockPaperScissors(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> betAmount() {
        final Function function = new Function(FUNC_BETAMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> finishGame() {
        final Function function = new Function(
                FUNC_FINISHGAME, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> makeChoice(BigInteger choice) {
        final Function function = new Function(
                FUNC_MAKECHOICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(choice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> player1() {
        final Function function = new Function(FUNC_PLAYER1, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> player1Choice() {
        final Function function = new Function(FUNC_PLAYER1CHOICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> player2() {
        final Function function = new Function(FUNC_PLAYER2, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> player2Choice() {
        final Function function = new Function(FUNC_PLAYER2CHOICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> register(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_REGISTER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static RockPaperScissors load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RockPaperScissors(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RockPaperScissors load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RockPaperScissors(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RockPaperScissors load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RockPaperScissors(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RockPaperScissors load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RockPaperScissors(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RockPaperScissors> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RockPaperScissors.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RockPaperScissors> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RockPaperScissors.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RockPaperScissors> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RockPaperScissors.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RockPaperScissors> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RockPaperScissors.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
