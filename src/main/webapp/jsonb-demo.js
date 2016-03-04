$.requestData = {
    hero: {
        heroClass: "BARBARIAN",
        name: "Jason"
    }
}

$(document).ready(function () {
    $("#go").click(function () {
        $.ajax({
            type: "POST",
            url: "/jsonb-demo/JsonbDemo",
            data: JSON.stringify({hero:$.requestData.hero}),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){
                console.log(data);
                $("#items>table>tbody").remove();
                $("#items>table").append($("<tbody></tbody>"));

                $.each(data.hero.items, function(key, value) {
                    console.log('key: ' + key + '\n' + 'value: ' + value);
                    var statsString = "";
                    $(value.stats).each(function(index) {
                        statsString += this.name + ':' + this.value + "; ";
                    })
                    $("#items>table>tbody").append($('<tr><td></td><td>'+key+'</td><td>'+value.name+'</td><td>'+statsString+'</td></tr>'));
                });

            },
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});

