// SPDX-License-Identifier: UNLICENSED

pragma solidity ^0.8.0;

contract RockPaperScissors {
    address public player1;
    address public player2;
    uint public player1Choice;
    uint public player2Choice;
    uint public betAmount;
    bool public gameFinished;
    
    function register() public payable {
        require(player1 == address(0) || player2 == address(0), "Both players are already registered");
        require(msg.value > 0, "Bet amount should be greater than 0");
        
        if (player1 == address(0)) {
            player1 = msg.sender;
        } else {
            player2 = msg.sender;
        }
        
        betAmount += msg.value;
    }
    
    function makeChoice(uint choice) public {
        require(msg.sender == player1 || msg.sender == player2, "Only registered players can make a choice");
        require(choice >= 1 && choice <= 3, "Invalid choice");
        
        if (msg.sender == player1) {
            player1Choice = choice;
        } else {
            player2Choice = choice;
        }
    }
    
    function finishGame() public {
        require(player1Choice > 0 && player2Choice > 0, "Both players should make a choice");
        require(!gameFinished, "Game is already finished");
        
        if (player1Choice == player2Choice) {
            payable(player1).transfer(betAmount / 2);
            payable(player2).transfer(betAmount / 2);
        } else if ((player1Choice == 1 && player2Choice == 2) || (player1Choice == 2 && player2Choice == 3) || (player1Choice == 3 && player2Choice == 1)) {
            payable(player1).transfer(betAmount);
        } else {
            payable(player2).transfer(betAmount);
        }
        
        gameFinished = true;
    }
}
