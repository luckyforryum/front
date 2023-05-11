fetch("http://localhost:8080/api/admin/me")
    .then(res => res.json())
    .then(data => {
            const navbarInfo = document.getElementById("navbar-info");
            navbarInfo.innerHTML = `
      <span style="color: white; margin-left: 10px;">${data.email} with roles: ${data.roles.map(role => role.name).join(" ")}</span>
      <a style="color: grey; margin-left: auto; margin-right: 10px;" href="/logout">Logout</a>
    `;
    });
