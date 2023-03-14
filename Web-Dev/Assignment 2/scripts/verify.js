var passin = document.getElementById("pass");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

var email = document.getElementById("email");
var emailin = document.getElementById("email2");

var passin2 = document.getElementById("pass2");


emailin.onkeyup = function () {
	var emailOne = email.value;
	var emailTwo = emailin.value;
	var infobox = document.getElementById('infobox');
	var emailReg = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	if (emailOne === emailTwo) {
		infobox.value = "";
	} else {
		infobox.value = "Emails are not equal";
	}

	if (!emailReg.test(emailTwo)){
		emailbox.value = "Not a valid email.";
	} else {
		emailbox.value = "";
	}
}

passin2.onkeyup = function () {
	var passOne = passin.value;
	var passTwo = passin2.value;
	var infobox = document.getElementById('infobox');

	if (passOne === passTwo) {
		infobox.value = "";
	} else {
		infobox.value = "Passwords are not equal";
	}
}

passin.onkeyup = function () {
	var lowerCaseLetters = /[a-z]/g; // Checking for lowercase characters.
	
	if (passin.value.match(lowerCaseLetters)) {
		letter.classList.remove("invalid");
		letter.classList.add("valid");
	} else {
		letter.classList.remove("valid");
		letter.classList.add("invalid");
    }

	var upperCaseLetters = /[A-Z]/g; // Checking for uppercase characters.
	
     if (passin.value.match(upperCaseLetters)) {
        capital.classList.remove("invalid");
        capital.classList.add("valid");
    } else {
        capital.classList.remove("valid");
        capital.classList.add("invalid");
    }

	var numbers = /[0-9]/g; // Checking for numbers.
    if (passin.value.match(numbers)) {
        number.classList.remove("invalid");
        number.classList.add("valid");
    } else {
        number.classList.remove("valid");
        number.classList.add("invalid");
    }

    if (passin.value.length >= 6) {
        length.classList.remove("invalid");
        length.classList.add("valid");
    } else {
        length.classList.remove("valid");
        length.classList.add("invalid");
    }
}