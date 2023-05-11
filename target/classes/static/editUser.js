function editUser() {
    // Получаем значения полей формы
    const id = document.getElementById('editID').value;
    const firstName = document.getElementById('editName').value;
    const lastName = document.getElementById('editLastName').value;
    const age = document.getElementById('editAge').value;
    const email = document.getElementById('editEmail').value;
    const password = document.getElementById('editPassword').value;
    const roles = Array.from(document.getElementById('editRoles').selectedOptions, option => {
      return {
        id: option.value,
        name: option.label
      };
    });
  
    // Создаем объект с измененными данными пользователя
    const user = {
      id: id,
      firstname: firstName,
      lastname: lastName,
      age: age,
      email: email,
      password: password,
      roles: roles
    };
  
    // Отправляем данные на сервер для обновления в базе данных
    $.ajax({
      type: 'PUT',
      url: 'http://localhost:8080/api/admin/editUser',
      data: JSON.stringify(user),
      contentType: 'application/json',
      success: function(data) {
        console.log('User updated:', data);
        $('#firstName').text(data.firstName);
        $('#lastName').text(data.lastName);
        $('#age').text(data.age);
        $('#email').text(data.email);
        $('#password').text(data.password);
        $('#roles').text(data.roles);
        updateUserTable();

      },
      error: function(error) {
        console.error('Error updating user:', error);
      }
    });
  }
  



