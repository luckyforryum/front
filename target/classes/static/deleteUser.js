function deleteUser(id) {
    if (typeof id === 'undefined') {
      console.error('User id is undefined');
      return;
    }
  
    fetch('http://localhost:8080/api/admin/delete/' + id, {
      method: 'DELETE',
      headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    .then(response => {
      $('#' + id).remove();
      updateUserTable(); // обновляем список пользователей
    });
  }
  