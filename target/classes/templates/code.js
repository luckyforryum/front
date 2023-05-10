showAllUsers();

function showAllUsers() {
    let tBody = document.getElementById("tBody");
    tBody.innerHTML = "";
    fetch('http://localhost:8080/api/admin/getAllUsers')
        .then(response => response.json())
        .then(users => {
            users.forEach(function (user) {
                const row = tBody.insertRow();
                row.setAttribute("id", user.id);
                const cell0 = row.insertCell();
                cell0.innerHTML = user.id;
                const cell1 = row.insertCell();
                cell1.innerHTML = user.firstname;
                const cell2 = row.insertCell();
                cell2.innerHTML = user.lastname;
                const cell3 = row.insertCell();
                cell3.innerHTML = user.age;
                const cell4 = row.insertCell();
                cell4.innerHTML = user.email;
                const cell5 = row.insertCell();
                cell5.innerHTML = listRoles(user).textContent;

                // const cell6 = row.insertCell();
                // cell6.innerHTML =
                //     '<button type="button" onclick="getModalEdit(' + user.id + ')" class="btn btn-primary btn-sm">Edit</button>';
                //
                // const cell7 = row.insertCell();
                // cell7.innerHTML =
                //     '<button type="button" onclick="getModalDelete(' + user.id + ')" class="btn btn-danger btn-sm">Delete</button>';
            })
        });
}