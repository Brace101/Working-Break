const prompt = require('prompt-sync')();

let numberOfSlices = 0;
let numberOfPeople;
let price = 0;
let continueOrder = "yes";

console.log("DEAR ESTEEMED CUSTOMER, YOU ARE WELCOME TO PIZZA WAHALA JOINT");
console.log("Kindly go through our menu list");

const menu = `
 ___________________________________________________
|           |                  |                    |  
|Pizza Type | Number of slices |  Prices per Box    |
|___________|__________________|____________________|           
|           |                  |                    |
| SAPA SIZE |       4          |    2,000           |
|___________|__________________|____________________|
|           |                  |                    | 
|SMALL MONEY|       6          |    2,400           |
|___________|__________________|____________________|
|           |                  |                    |
| BIG BOYS  |       8          |    3,000           |
|___________|__________________|____________________|                
|           |                  |                    |
| ODOGWU    |       12         |    4,200           | 
|___________|__________________|____________________|
`;

console.log(menu);

while (continueOrder.toLowerCase() === "yes") {

    console.log("Dear Customer, kindly place your order here (Pizza Type)");
    let order = prompt().toUpperCase();

    console.log("Kindly input number of people");
    numberOfPeople = parseInt(prompt());

    switch (order) {
        case "SAPA SIZE":
            price = 2000;
            numberOfSlices = 4;
            break;

        case "SMALL MONEY":
            price = 2400;
            numberOfSlices = 6;
            break;

        case "BIG BOYS":
            price = 3000;
            numberOfSlices = 8;
            break;

        case "ODOGWU":
            price = 4200;
            numberOfSlices = 12;
            break;

        default:
            console.log("Invalid selection");
            continue;
    }

    let numberOfBoxes = Math.ceil(numberOfPeople / numberOfSlices);
    console.log("Number of boxes: " + numberOfBoxes);

    let remainingSlices = (numberOfBoxes * numberOfSlices) - numberOfPeople;
    console.log("Remaining slices: " + remainingSlices);

    let totalPrice = numberOfBoxes * price;
    console.log("Total price: ₦" + totalPrice);

    console.log("\nKindly make your payment:");
    console.log("\tADEYEMI OLALEKAN ABIDEMI\n\t8100203675\n\tMONIEPOINT\n");

    console.log("Would you like to place another order? Yes / No");
    continueOrder = prompt();
}

console.log("Thanks for your patronage, ENJOY YOUR PIZZA 🍕");
