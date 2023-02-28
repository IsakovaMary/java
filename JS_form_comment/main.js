// function clickHref() {
// 	alert ('Ghbdtn dctv!');
// 	document.querySelector("a.href").style.color = "#333";
// 	document.querySelector("a.href").style.textDecoration = "none";
// }

// let input = document.querySelector("input");
// let ah = document.querySelector("a.href");

// function clickText(selector) {
// 	document.querySelector(selector).style.backgroundColor = "green";
// 	document.querySelector(selector).style.color = "#fff";
// }

// function focusEvent(){
// 	input.style.backgroundColor = "#333";
// 	input.style.padding = "10px";
// 	input.style.border = "0";
// }

// function focusEndEvent() {
// 	input.style.backgroundColor = "#fff";
// 	input.style.padding = "0px";
// 	input.style.border = "1px solid silver";
// }

// ah.ondragend = function () {
// 	console.log('click')
// };

// window.onresize = function() {
// 	console.log('изменение ширины и высота');
// };

// window.onload = function() {
// 	console.log('Страница загрузилась');
// };

// window.onscroll = function() {
// 	console.log('Сcroll');
// };

// document.querySelector(".full-text").oninput = function() {
// 	console.log('Вы что-то вводите');
// };

// //-----------------------------

// let block = document.querySelector("div.block");

// function handlerOver() {
// 	block.innerHTML = 'Новый текст';
// }
// function handlerOut(){
// 	block.innerHTML = 'new текст';
// }

// //убирается присатвка on

// block.addEventListener("mouseover", handlerOver);
// block.addEventListener("mouseout",handlerOut);

// block.removeEventListener("mouseout", handlerOut);

let boldTxt = document.querySelectorAll("p > b.bold-text");

boldTxt.forEach(function(item, index) {
	item.onmouseup = function() {
	item.style.color = "blue"
}
})

boldTxt.onmouseup = function() {
	boldTxt.style.color = "blue"
}

boldTxt.oncontextmenu = function() {
	boldTxt.style.color = "green"
}

let inputField = document.querySelector(".input");
let helpField = document.querySelector(".hint");

inputField.onmouseenter = function() {
	helpField.style.display = "block";
}

inputField.onmousemove = function(e) {
	helpField.style.left = e.offsetX + "px";
	helpField.style.top = e.offsetY + "px";
}

inputField.onmouseleave = function() {
	helpField.style.display = "none";
}
