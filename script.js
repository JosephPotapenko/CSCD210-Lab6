// Function to count odd, even, and zero digits
function countOddEvenZero(theNum) {
    let copy = theNum;
    let even = 0, odd = 0, zero = 0;

    while (copy > 0) {
        let digit = copy % 10;
        if (digit === 0) zero++;
        else if (digit % 2 === 0) even++;
        else odd++;
        copy = Math.floor(copy / 10);
    }

    return `${theNum} has ${odd} odd(s), ${even} even(s), and ${zero} zero(s).`;
}

// Function to determine if the number is light or heavy
function determineLightHeavy(theNum) {
    let sum = 0, count = 0, copy = theNum;

    // Calculate the average of the first number
    while (copy > 0) {
        sum += copy % 10;
        count++;
        copy = Math.floor(copy / 10);
    }

    let theNumAvg = sum / count;

    // Get the second number from the input
    let secondNum = parseInt(document.getElementById("secondNum").value);
    if (isNaN(secondNum) || secondNum < 1) {
        return "Please enter a valid second positive number.";
    }

    sum = 0;
    count = 0;
    copy = secondNum;

    // Calculate the average of the second number
    while (copy > 0) {
        sum += copy % 10;
        count++;
        copy = Math.floor(copy / 10);
    }

    let secondNumAvg = sum / count;

    // Compare averages and return the result
    if (theNumAvg > secondNumAvg) {
        return `The initial number ${theNum} is heavy.`;
    } else {
        return `The initial number ${theNum} is light.`;
    }
}

// Function to approximate the mathematical constant E
function computeE(theNum) {
    let sum = 1.0;

    for (let x = 1; x <= theNum; x++) {
        let factorial = 1;
        for (let y = 1; y <= x; y++) {
            factorial *= y;
        }
        sum += (1 / factorial);
    }

    return `Approximated value of E: ${sum.toFixed(6)}`;
}

// Function to reverse the number
function reverseNumber(theNum) {
    return `Reversed number: ${theNum.toString().split('').reverse().join('')}`;
}

// Function to process user choice
function processChoice() {
    let theNum = parseInt(document.getElementById("theNum").value);
    let choice = parseInt(document.getElementById("choice").value);
    let result = "";

    // Ensuring a valid number is entered
    if (isNaN(theNum) || theNum < 1) {
        result = "Please enter a valid positive number.";
    } else {
        switch (choice) {
            case 1:
                result = `New number entered: ${theNum}`;
                break;
            case 2:
                result = countOddEvenZero(theNum);
                break;
            case 3:
                result = determineLightHeavy(theNum);
                break;
            case 4:
                result = computeE(theNum);
                break;
            case 5:
                result = reverseNumber(theNum);
                break;
            case 6:
                result = "Exiting the program.";
                break;
            default:
                result = "Invalid choice. Please try again.";
        }
    }

    document.getElementById("result").innerText = result;
}