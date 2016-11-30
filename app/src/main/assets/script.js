"use strict";

console.log("here we are in a script");

var groom = document.getElementById("groom");
var bride = document.getElementById("bride");
var fab = document.getElementById("fab");

groom.addEventListener('click', () => {
    javaLogic.toastToTheGroom();
});

bride.addEventListener('click', () => {
    javaLogic.toastToTheBride();
});