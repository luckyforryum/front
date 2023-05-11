
fetch("http://localhost:8080/api/admin/me")
    .then(res=>{
        res.json().then(
            data=>{
                console.log(data);

                    var temp = "";

                        temp += "<tr>";
                        temp += "<td>" + data.id + "</td>";
                        temp += "<td>" + data.firstname + "</td>";
                        temp += "<td>" + data.lastname + "</td>";
                        temp += "<td>" + data.age + "</td>";
                        temp += "<td>" + data.email + "</td>";
                        temp += "<td>" + data.roles.map(role => role.name).join(" ") + "</td>";
                        temp += "</tr>";

                    
                    document.getElementById("user_info").innerHTML = temp;

            }
        )
    })