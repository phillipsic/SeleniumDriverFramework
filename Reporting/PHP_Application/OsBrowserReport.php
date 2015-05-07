<?php
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";
include "./header.html";
?>
<head>
    <title>Test Maintenance Report</title>
    <link type="text/css" rel="stylesheet" href="../yui/build/datatable/assets/skins/sam/datatable.css"/>
    <script type="text/javascript" src="../yui/build/yahoo-dom-event/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="../yui/build/element/element-beta-min.js"></script>
    <script type="text/javascript" src="../yui/build/datasource/datasource-beta-min.js"></script>
    <script type="text/javascript" src="../yui/build/json/json-min.js"></script>
    <script type="text/javascript" src="../yui/build/connection/connection-min.js"></script>
    <script type="text/javascript" src="../yui/build/dragdrop/dragdrop-min.js"></script>
    <script type="text/javascript" src="../yui/build/calendar/calendar-min.js"></script>
    <script type="text/javascript" src="../yui/build/datatable/datatable-beta-min.js"></script>
</head>
<body class=" yui-skin-sam"> 

    <?php
    //oracle connection variables
   //$connect = ocilogon("CQ_RO", "comverse", "cqprdcbs");







    echo "<h2>OS and Browser Report</h2>";

    include "./constants.inc.php";
    include "./Mysql.obj.php";


    $DBConnection = new mysql;
    $DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);

    if (isset($_GET['tag'])) {

        $tag = $_GET['tag'];
    }
    if (isset($_POST[tag])) {

        $tag = $_POST[tag];
    }





    $selectedApplication = $_POST[selectedApplication];
    $selectedBuild = $_POST[selectedBuild];

    $appQuery = "SELECT distinct application from test_results;";
    $appResult = mysql_query($appQuery);


    $LastFiveBuildsQuery = "select distinct version from csspqa.test_results  order by id desc limit 5;";
    $LastFiveBuildsResult = mysql_query($LastFiveBuildsQuery);




    echo "<b>Deployment Mode - " . strtoupper($tag) . "</b><br>";
    echo "<b>selected application is - " . $selectedApplication . "</b><br>";
    echo "<b>selected build is - " . $selectedBuild . "</b><br>";




    echo "<form name=frmTest action='OsBrowserReport.php?tag=cv' method=POST>";
    echo "<table>";
    echo "<TR><TD><SELECT NAME='selectedApplication'>";
    echo " <OPTION VALUE=\"\">Select App</OPTION>";

    while ($row = mysql_fetch_assoc($appResult)) {

        echo "<OPTION VALUE='" . $row['application'] . "'>" . $row['application'] . "</OPTION>";
    }
    echo "</SELECT></TD>";


    echo "<TD><SELECT NAME='selectedBuild' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select Build</OPTION>";

    while ($row = mysql_fetch_assoc($LastFiveBuildsResult)) {

        echo "<OPTION VALUE='" . $row['version'] . "'>" . $row['version'] . "</OPTION>";
    }


    echo "</SELECT></TD></TR></TABLE>";



    echo "<input type='hidden' name='tag' value='" . $tag . "'";

    echo "</form>";


    if ($selectedApplication != "" && $selectedBuild != "") {



        $DistinctTestScriptQuery = "select distinct test_id from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' and WebTestFlag is null order by test_id";

        //echo "executing: " . $DistinctTestScriptQuery;

        $DistinctTestScriptResult = mysql_query($DistinctTestScriptQuery);


        // Get list of broswers and applications the build/app have been run on

        $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' and WebTestFlag is null order by test_id";
        $platformsExecutedOnResult = mysql_query($platformsExecutedOnQuery);

        // echo $platformsExecutedOnQuery;




        echo "<div id=\"myMarkedUpContainer\">";
        echo "<BR><Table id='myTable'><thead>";
        echo "<TR><TH>Test ID</TH>";

        while ($row = mysql_fetch_array($platformsExecutedOnResult, MYSQL_ASSOC)) {
            echo "<TH> " . $row["browser"] . "</th>";
        }
        echo "</thead><tbody>\n";

        mysql_data_seek($platformsExecutedOnResult, 0);


        while ($testrow = mysql_fetch_assoc($DistinctTestScriptResult)) {


            echo "<BR><tr><td> <a href='testdeatailreport.php?test_id=" . urlencode($testrow['test_id']) . "&app=" . $selectedApplication . "'>" . $testrow['test_id'] . "</a></td>";
            while ($row = mysql_fetch_array($platformsExecutedOnResult, MYSQL_ASSOC)) {

                $TestPassResultQuery = " select count(*) from test_results where test_id = '" . $testrow['test_id'] . "' and browser = '" . $row["browser"]  . "'and tag = '" . $tag . "' and test_result ='pass' and version like ('%" . $selectedBuild . "%') and application = '" . $selectedApplication . "'";
                // echo $TestPassResultQuery;
                $TestPassResult = mysql_query($TestPassResultQuery);
                $NumberOfPasses = mysql_result($TestPassResult, 0);

                if ($NumberOfPasses < 1) {

                    $numberOfFailedQuery = " select count(*) from test_results where test_id = '" . $testrow['test_id'] . "' and browser = '" . $row["browser"]  . "'and tag = '" . $tag . "' and version like ('%" . $selectedBuild . "%') and application = '" . $selectedApplication . "'";
                    // echo $TestPassResultQuery;
                    $numberOfFailedResult = mysql_query($numberOfFailedQuery);
                    $numberOfFails = mysql_result($numberOfFailedResult, 0);

                    if ($numberOfFails < 1) {

                        $result = "<CENTER><FONT COLOR=\"BLACK\">Not Run</FONT></CENTER>";
                    } else {

                        $result = "<CENTER><FONT COLOR=\"RED\">Fail</FONT></CENTER>";
                    }
                } else {
                    $result = "<CENTER><FONT COLOR=\"GREEN\">Pass</FONT></CENTER>";
                }
                echo "<td>" . $result . "</td>";
            }


            $lastPassedQuery = "select time_stamp from test_results where test_id = '" . $testrow['test_id'] . "' and application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by id desc limit 1";

            // echo $lastPassedQuery;
            $lastPassedResult = mysql_query($lastPassedQuery);
            $lastPass = mysql_result($lastPassedResult, 0);

            echo "<td>" . $lastPass . " </td></tr>";
            mysql_data_seek($platformsExecutedOnResult, 0);
        }



        // echo "<TR>";
        //  echo "<TD><a href='testdeatailreport.php?test_id=" . urlencode($row['test_id']) . "&app=" . $selectedApplication . "'>" . $row['test_id'] . "</a> </TD>";
        //  echo "<TD>" . $passrow['version'] . "</TD>";
        //  echo "</TR>";



        echo "</tbody></Table ></div>";
    }
    // 
    ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key:"Test ID"},<?
    $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' and WebTestFlag is null order by test_id";
    $platformsExecutedOnResult = mysql_query($platformsExecutedOnQuery);
    while ($row = mysql_fetch_array($platformsExecutedOnResult, MYSQL_ASSOC)) {
        echo "{key: \"" . $row["browser"] . "\"},";
    }
    ?>
                {key:"Last Pass"}
            ]};

        var myColumnDefs = [
            {key:"Test ID", label:"Test ID", sortable:true},<?
    $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' and WebTestFlag is null order by test_id";
    $platformsExecutedOnResult = mysql_query($platformsExecutedOnQuery);

    while ($row = mysql_fetch_array($platformsExecutedOnResult, MYSQL_ASSOC)) {
        echo "{key:\"" . $row["browser"] . "\", label:\"" . $row["browser"]  . "\", sortable:true},";
    }
    ?>
            {key:"Last Pass", label:"Last Run", sortable:true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns:true});


       
    </script>


</body>
</html>
