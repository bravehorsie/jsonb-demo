<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <script src="${pageContext.request.contextPath}/jquery-2.2.1.min.js"></script>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>--%>
    <script type="text/javascript" src="jsonb-demo.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/jsonb-demo.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container">
            <a class="navbar-brand" href="#">JSONB Demo</a>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <div class="row">
        <div class="col-md-8 content">
            <div id="items">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Slot</th>
                        <th>Name</th>
                        <th>Stats</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Weapon</td>
                        <td>Sword of the Skeleton king</td>
                        <td>Strength: 200, Vitality: 80</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Head</td>
                        <td>Helm of Illusionist</td>
                        <td>Strength: 115, Vitality: 30</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-4 content">
            <div id="json-log" class="log">
                <p> --- jetty-maven-plugin:9.2.14.v20151106:run-exploded (default-cli) @ jsonb-demo ---</p>
                <p> Copying webapp resources [/home/roma/java/jsonb-demo/src/main/webapp]</p>
            </div>
            <div id="combat-log" class="log">
                <p> Jason encounters gropup of skeletons with a spider queen.</p>
                <p> Jason breaks all five skeleton spines in one sword swing.</p>
                <p> Jason pours a spider queen with a canister of gas and burns it to ashes.</p>
                <p> That was way too easy task for Jason.</p>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <button type="submit" class="btn btn-danger" id="go">Send Jason questing</button>
        </div>
    </div>
</div><!-- /.container -->

</body>
</html>
