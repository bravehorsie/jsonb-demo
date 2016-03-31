$.requestData = {
    hero: {
        heroClass: "BARBARIAN",
        name: "Jason"
    }
};

$.siteHandler = {
    parseResponse: function(data){
        console.log(data);
        $.siteHandler.parseLoot(data);
        $.siteHandler.parseCombatLog(data);
        $.siteHandler.parseTotals(data);
    },
    parseCombatLog: function (data) {
        var combatLogDiv = $("#combat-log");
        combatLogDiv.append($('<p>=============================</p>'));
        var newP = $('<p/>');
        $(data.combatLog.messages).each(function () {
            newP.append(this + '<br/>');
        });
        combatLogDiv.append(newP);
        combatLogDiv.animate({scrollTop: combatLogDiv.prop("scrollHeight")}, 1000);
    },
    parseLoot: function (data) {
        $.requestData.hero = data.hero;
        $("#items>table>tbody").remove();
        $("#items>table").append($("<tbody></tbody>"));

        $.each(data.hero.hero_items, function (key, value) {
            console.log('key: ' + key + '\n' + 'value: ' + value);
            var statsString = "";
            $(value.stats).each(function (index) {
                statsString += this.name + ':' + this.value + "; ";
            })
            $("#items>table>tbody").append($('<tr><td></td><td>' + key + '</td><td>' + value.name + '</td><td>' + statsString + '</td></tr>'));
        });
    },
    parseTotals: function(data) {
        $('#stats-summary').replaceWith($('<h2 id="stats-summary"><small>Strength: ' + data.hero.total_strength + ', Vitality: '+data.hero.total_vitality+'</small></h2>'));
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
            success: $.siteHandler.parseResponse,
            failure: function(errMsg) {
                alert(errMsg);
            }
        });
    });
});

