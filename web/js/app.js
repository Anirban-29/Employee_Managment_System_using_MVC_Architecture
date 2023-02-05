/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const    regName = /\d+$/g;
const    regPhone = /^\d{10}$/;

const form = document.querySelector('#create-account-form');
const usernameInput = document.querySelector('#firstname');
const lastnameInput = document.querySelector('#lastname');
const phoneInput = document.querySelector('#phone');



form.addEventListener('submit', (event) => {

    validateForm();
    console.log(isFormValid());
    if (isFormValid() == true) {
        form.submit();
    } else {
        event.preventDefault();
    }

});

function isFormValid() {
    const inputContainers = form.querySelectorAll('.input-group');
    let result = true;
    inputContainers.forEach((container) => {
        if (container.classList.contains('error')) {
            result = false;
        }
    });
    return result;
}

function validateForm() {
    //firstNAME
    if (usernameInput.value.trim() == '') {
        setError(usernameInput, 'Name can not be empty');
    } else if (usernameInput.value.trim().length < 5 || usernameInput.value.trim().length > 15) {
        setError(usernameInput, 'Name must be min 5 and max 15 charecters');
    } else if (regName.test(usernameInput.value.trim()))
    {
        setError(usernameInput, 'Name can not contain digits');
    } else {
        setSuccess(usernameInput);
    }
    //lastName
     if (lastnameInput.value.trim() == '') {
        setError(lastnameInput, 'Name can not be empty');
    } else if (lastnameInput.value.trim().length < 5 || lastnameInput.value.trim().length > 15) {
        setError(lastnameInput, 'Name must be min 5 and max 15 charecters');
    } else if (regName.test(lastnameInput.value.trim()))
    {
        setError(lastnameInput, 'Name can not contain digits');
    } else {
        setSuccess(lastnameInput);
    }
    //phone
    if (phoneInput.value.trim() == '') {
        setError(phoneInput, 'Phone number can not be empty');
    } else if (phoneInput.value.trim().length < 10 ) {
        setError(phoneInput, 'Phone number must be 10 digits');
    }else if(phoneInput.value.trim().length > 10) 
    {
        setError(phoneInput, 'Phone number can not be more than 10 digits');

    }else if (!regPhone.test(phoneInput.value.trim()))
    {
        setError(phoneInput, 'Name can not contain characters');
    } else {
        setSuccess(phoneInput);
    }
    
}

function setError(element, errorMessage) {
    const parent = element.parentElement;
    if (parent.classList.contains('success')) {
        parent.classList.remove('success');
    }
    parent.classList.add('error');
    const paragraph = parent.querySelector('p');
    paragraph.textContent = errorMessage;
}

function setSuccess(element) {
    const parent = element.parentElement;
    if (parent.classList.contains('error')) {
        parent.classList.remove('error');
    }
    parent.classList.add('success');
}




