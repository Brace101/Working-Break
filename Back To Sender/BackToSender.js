const prompt = require('prompt-sync')();

let payment = 0;
let counter = 0;
let numOfDelivery = 0;
let rider = "start";

const riderMenu = `
 ___________________________________________________
|                |                  |               |   
|Collection Rate | Amount per parcel|  Base Pay     |
|________________|__________________|_______________|
|                |                  |               | 
| Less than 50   |              160 |    5,000      |
|________________|__________________|_______________|       
|                |                  |               |
| 50 - 59        |              200 |    5,000      |
|________________|__________________|_______________|
|                |                  |               |
| 60 - 69        |              250 |    5,000      |
|________________|__________________|_______________|
|                |                  |               |
| >=70           |              500 |    5,000      |
|________________|__________________|_______________|
`;

console.log(riderMenu);

while (rider === "start") {

    console.log("Enter number of successful delivery: ");
    numOfDelivery = parseFloat(prompt());

    if (numOfDelivery < 0) {
        console.log("There's no payment for you");
    } 
    else if (numOfDelivery <= 50) {
        payment = (numOfDelivery * 160) + 5000;
        console.log("The payment for the day is: " + payment);
    } 
    else if (numOfDelivery > 50 && numOfDelivery <= 59) {
        payment = (numOfDelivery * 200) + 5000;
        console.log("The payment for the day is: " + payment);
    } 
    else if (numOfDelivery >= 60 && numOfDelivery <= 69) {
        payment = (numOfDelivery * 250) + 5000;
        console.log("The payment for the day is: " + payment);
    } 
    else if (numOfDelivery >= 70) {
        payment = (numOfDelivery * 500) + 5000;
        console.log("The payment for the day is: " + payment);
    }

    console.log();

    while (rider === "start") {
        console.log("Would you like to calculate for more dispatcher? Yes / No");
        let moreRider = prompt();

        if (moreRider.toLowerCase() === "yes") {
            counter++;
            break;
        } 
        else if (moreRider.toLowerCase() === "no") {
            console.log("Thanks for using this app");
            rider = "stop";
            break;
        } 
        else {
            console.log("Invalid input");
        }
    }
}
