$(document).ready(function () {
    $.get({
        url: "http://localhost:8080/rest/users",
        success: function (data) {
            data.forEach(function (item) {
                $("#users").append(
                    `<li>
<h3>id: ${item.id}, email: ${item.email}</h3>
</li> <hr>`
                );
            });

        }
    })
});