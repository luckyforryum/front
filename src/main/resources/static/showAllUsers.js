fetch("http://localhost:8080/api/admin/getAllUsers")
.then(res=>{
    res.json().then(
        data=>{
            console.log(data);
            if(data.length > 0) {
                var temp = "";
                data.forEach((u)=>{
                    temp += "<tr>";
                    temp += "<td>" + u.id + "</td>";
                    temp += "<td>" + u.firstname + "</td>";
                    temp += "<td>" + u.lastname + "</td>";
                    temp += "<td>" + u.age + "</td>";
                    temp += "<td>" + u.email + "</td>";
                    temp += "<td>" + u.roles.map(role => role.name).join(" ") + "</td>";
                    temp += '<td><button type="button" onclick="getModalEdit(' + u.id + ')" class="btn btn-primary btn-sm">Edit</button></td>';
                        temp += '<td><button type="button" onclick="getModalDeleteUser(' + u.id + ')" class="btn btn-danger btn-sm">Delete</button></td>';
                    temp += "</tr>";

                })
                document.getElementById("tBody").innerHTML = temp;
            }
        }
    )
})