const conData = document.querySelector('#data');
let db

function save(){
	const contactId = document.querySelector('#contactId').value
	const fnameInput = document.querySelector('#fname').value;
	const lnameInput = document.querySelector('#lname').value;
	const telInput = document.querySelector('#tel').value;
	const emailInput = document.querySelector('#email').value;
	const activeInput = document.querySelector('#active').value;
	if(!fnameInput){
		alert("first name is required");
	}
	if(!lnameInput){
		alert("last name is required");
	}
	if(!telInput){
		alert("Telephone is required");
	}
	if(!emailInput){
		alert("Email is required");
	}

	let request = new XMLHttpRequest();
	if(contactId){
		request.open("PUT", "/contacts/"+contactId, false);
	}else{
		request.open("POST", "/contacts", false);
	}
	
	request.setRequestHeader("content-type", "application/json")
	request.send(JSON.stringify({
		"firstName":fnameInput,
		"lastName":lnameInput,
		"email":emailInput,
		"phoneNumber":telInput,
		"active":activeInput
		}));
	console.log(request)
	if(request.status === 400){
		alert(request.responseText);
	}else{
		alert("Data has been successfully saved!");
		document.querySelector("#contactForm").reset();
		fetchdata();
	}
}



function displayData() {
    while (conData.firstChild) {
      conData.removeChild(conData.firstChild);
    }

    let contacts = db;

    for(var i=0;i<db.length;i++) {
      let data = db[i];

      if(data) {
        let tr = document.createElement('tr');
        let tdId = document.createElement('td');
        let tdFName = document.createElement('td'); 
        let tdLname = document.createElement('td');
        let tdEmail = document.createElement('td');
        let tdTel = document.createElement('td');
        let tdActive = document.createElement('td');
        
        tr.appendChild(tdId);
        tr.appendChild(tdFName);
        tr.appendChild(tdLname);
        tr.appendChild(tdEmail);
        tr.appendChild(tdTel);
        tr.appendChild(tdActive);
        conData.appendChild(tr);

        tdId.textContent = data.id;
        tdFName.textContent = data.firstName;
        tdLname.textContent = data.lastName;
        tdEmail.textContent = data.email;
        tdTel.textContent = data.phoneNumber;
        tdActive.textContent = data.active;
        
        tdFName.setAttribute('data-contact-fname',data.firstName );
        tdLname.setAttribute('data-contact-lname',data.lastName );
        tdEmail.setAttribute('data-contact-email',data.email );
        tdTel.setAttribute('data-contact-phoneNumber',data.phoneNumber );
        tdActive.setAttribute('data-contact-active',data.active );
        
        tr.setAttribute('data-contact-id', data.id);

        let deleteBtn = document.createElement('button');
        let editBtn = document.createElement('button');
        editBtn.textContent = 'Edit';
        deleteBtn.textContent = 'Delete';
        tr.appendChild(deleteBtn);
        tr.appendChild(editBtn);
        editBtn.onclick = editItem;
        deleteBtn.onclick = deleteItem;
      } 
      else {
        if(!conData.firstChild) {
          let para = document.createElement('p');
          para.textContent = 'No contact stored.'
          conData.appendChild(para);
        }
        console.log('Notes all displayed');
      }
    };
  }

function editItem(e) {
    let contactId = Number(e.target.parentNode.getAttribute('data-contact-id'));
    getContact(contactId)
 }

function getContact(id){
  let request = new XMLHttpRequest();
	request.open("GET", "/contacts/"+id, false);
	request.send();
	contact = eval("("+request.responseText+")");
	document.querySelector('#contactId').value = contact.id;
	document.querySelector('#fname').value = contact.firstName;
	document.querySelector('#lname').value = contact.lastName;
	document.querySelector('#tel').value = contact.phoneNumber;
	document.querySelector('#email').value = contact.email;
	document.querySelector('#active').value = contact.active;
}

function deleteItem(e) {
    let contactId = Number(e.target.parentNode.getAttribute('data-contact-id'));
    let request = new XMLHttpRequest();
	request.open("DELETE", "/contacts/"+contactId, false);
	request.send();
	if(request.status === 400){
		alert("Something went wrong.Try after some time.");
	}else{
		alert("Data has been successfully deleted!")
		fetchdata();
	}
  }

function fetchdata(){
	let request = new XMLHttpRequest();
	request.open("GET", "/contacts", false);
	request.send();
	db = eval("("+request.responseText+")");
	displayData();
}

window.onload = () => {
	fetchdata();
}