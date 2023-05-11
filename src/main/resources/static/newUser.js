async function newUser() {
  // собираем данные из формы
  const firstName = document.getElementById('newName').value;
  const lastName = document.getElementById('newLastName').value;
  const age = document.getElementById('newAge').value;
  const email = document.getElementById('newEmail').value;
  const password = document.getElementById('newPasswd').value;
  const roles = Array.from(document.getElementById('newRoles').selectedOptions, option => {
    return {
      id: option.value,
      name: option.label
    };
  });

  // создаем JSON-объект
  const user = {
    firstname: firstName,
    lastname: lastName,
    age: age,
    email: email,
    password: password,
    roles: roles
  };

  console.log(user); // для проверки, что объект user был создан правильно

  // отправляем данные на сервер
  const response = await fetch('http://localhost:8080/api/admin/addNewUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
  });

  // проверяем статус ответа
  if (response.ok) {
    console.log('Пользователь успешно добавлен');
    // обновляем страницу
    location.reload();
  } else {
    console.error('Произошла ошибка при добавлении пользователя:', response.statusText);
  }
}
