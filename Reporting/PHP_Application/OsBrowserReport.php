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
    $link = $DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);






//    $selectedApplication = $_POST[selectedApplication];
//    $selectedBuild = $_POST[selectedBuild];
//
//    $appQuery = "SELECT distinct application from test_results;";
//    $appResult = mysqli_query($link, $appQuery);
//
//
//    $LastFiveBuildsQuery = "select distinct version from autotest.test_results  order by id desc limit 5;";
//    $LastFiveBuildsResult = mysqli_query($link, $LastFiveBuildsQuery);
//
//
//
//
////    echo "<b>Deployment Mode - " . strtoupper($tag) . "</b><br>";
//    echo "<b>selected application is - " . $selectedApplication . "</b><br>";
//    echo "<b>selected build is - " . $selectedBuild . "</b><br>";
//
//
//
//
//    echo "<form name=frmTest action='OsBrowserReport.php' method=POST>";
//
//    echo "<table>";
//    echo "<TR><TD><SELECT NAME='selectedApplication'>";
//    echo " <OPTION VALUE=\"\">Select App</OPTION>";
//
//    while ($row = $appResult->fetch_array(MYSQLI_ASSOC)) {
//
//        echo "<OPTION VALUE='" . $row['application'] . "'>" . $row['application'] . "</OPTION>";
//    }
//    echo "</SELECT></TD>";
//
//
//    echo "<TD><SELECT NAME='selectedBuild' onChange='frmTest.submit();'>";
//    echo " <OPTION VALUE=\"\">Select Build</OPTION>";
//
//    while ($row = $LastFiveBuildsResult->fetch_array(MYSQLI_ASSOC)) {
//
//        echo "<OPTION VALUE='" . $row['version'] . "'>" . $row['version'] . "</OPTION>";
//    }
//
//
//    echo "</SELECT></TD></TR></TABLE>";
//
//
//
////    echo "<input type='hidden' name='tag' value='" . $tag . "'";
//
//    echo "</form>";
//
//
//    if ($selectedApplication != "" && $selectedBuild != "") {
        
        
        

    $selectedApplication = $_POST[selectedApplication];
    $selectedBuild = $_POST[selectedBuild];

    $appQuery = "SELECT distinct application from test_results;";
    $appResult = mysqli_query($link, $appQuery);


    $LastFiveBuildsQuery = "select distinct version from autotest.test_results  order by time_stamp desc limit 15;";
    $LastFiveBuildsResult = mysqli_query($link, $LastFiveBuildsQuery);

    echo "<BR>selected application is - " . $selectedApplication;
    echo "<BR>selected build  is - " . $selectedBuild . "<br><br><br>";



    echo "<form name=frmTest action='OsBrowserReport.php' method=POST>";
    echo "<SELECT NAME='selectedApplication' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select App</OPTION>";

    while ($row = mysqli_fetch_row($appResult)) {

        echo "<OPTION VALUE='" . $row[0] . "'>" . $row[0] . "</OPTION>";
    }


    echo "</SELECT>";

    echo "</form>";



//    echo "</form>";

    if ($selectedBuild == "") {
        if ($selectedApplication != "") {

            $ListOfTestsForSelectedAppQuery = "select distinct version from autotest.test_results  where application = '" . $selectedApplication . "' order by time_stamp desc;";
            $ListOfTestsForSelectedAppResult = mysqli_query($link, $ListOfTestsForSelectedAppQuery);



            echo "<form name=formTest action='OsBrowserReport.php' method=POST>";
            echo "<SELECT NAME='selectedBuild' onChange='formTest.submit();'>";
            echo " <OPTION VALUE=\"\">Select Build</OPTION>";

            while ($row1 = mysqli_fetch_row($ListOfTestsForSelectedAppResult)) {

                echo "<OPTION VALUE='" . $row1[0] . "'>" . $row1[0] . "</OPTION>";
            }
            echo "<input type='hidden' name='selectedApplication' value='" . $selectedApplication . "'";
            echo "</SELECT></FORM>";
        }
    } else {



        $DistinctTestScriptQuery = "select distinct test_id from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by test_id";

        //echo "executing: " . $DistinctTestScriptQuery;

        $DistinctTestScriptResult = mysqli_query($link, $DistinctTestScriptQuery);


        // Get list of broswers and applications the build/app have been run on

        $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by test_id";
        $platformsExecutedOnResult = mysqli_query($link, $platformsExecutedOnQuery);

        // echo $platformsExecutedOnQuery;



        echo "<center>";
        echo "<div id=\"myMarkedUpContainer\">";
        echo "<BR><Table id='myTable'><thead>";
        echo "<TR><TH>Test ID</TH>";

        while ($row = $platformsExecutedOnResult->fetch_array(MYSQLI_ASSOC)) {
            echo "<TH> " . $row["browser"] . "</th>";
        }
        echo "</thead><tbody>\n";

        mysqli_data_seek($platformsExecutedOnResult, 0);


        while ($testrow = $DistinctTestScriptResult->fetch_array(MYSQLI_ASSOC)) {


            echo "<BR><tr><td> <a href='versionReport.php?selectedScript=" . urlencode($testrow['test_id']) . "&selectedApplication=" . $selectedApplication . "'>" . $testrow['test_id'] . "</a></td>";
            while ($row = $platformsExecutedOnResult->fetch_array(MYSQLI_ASSOC)) {

                $TestPassResultQuery = " select count(*) from test_results where test_id = '" . $testrow['test_id'] . "' and browser = '" . $row["browser"] . "' and test_result ='pass' and version like ('%" . $selectedBuild . "%') and application = '" . $selectedApplication . "'";
//                 echo $TestPassResultQuery;
                $TestPassResult = mysqli_query($link, $TestPassResultQuery);
                $NumberOfPasses = mysqli_fetch_row($TestPassResult);

//                echo "number of passes".$NumberOfPasses[0];

                if ($NumberOfPasses[0] < 1) {

                    $numberOfFailedQuery = " select count(*) from test_results where test_id = '" . $testrow['test_id'] . "' and browser = '" . $row["browser"] . "' and test_result = 'fail' and version like ('%" . $selectedBuild . "%') and application = '" . $selectedApplication . "'";
                    // echo $TestPassResultQuery;
                    $numberOfFailedResult = mysqli_query($link, $numberOfFailedQuery);
                    $numberOfFails = mysqli_fetch_row($numberOfFailedResult);

//                    echo $numberOfFailedQuery;
//                    echo "number of fails ". $numberOfFails;

                    if ($numberOfFails[0] < 1) {

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
            $lastPassedResult = mysqli_query($link, $lastPassedQuery);
            $lastPass = mysqli_fetch_row($lastPassedResult);

            echo "<td>" . $lastPass[0] . " </td></tr>";
            mysqli_data_seek($platformsExecutedOnResult, 0);
        }



        // echo "<TR>";
        //  echo "<TD><a href='testdeatailreport.php?test_id=" . urlencode($row['test_id']) . "&app=" . $selectedApplication . "'>" . $row['test_id'] . "</a> </TD>";
        //  echo "<TD>" . $passrow['version'] . "</TD>";
        //  echo "</TR>";



        echo "</tbody></Table ></div>";
        echo "</center>";
    }
    // 
    ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
        fields: [
        {key:"Test ID"},<?
    $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by test_id";
    $platformsExecutedOnResult = mysqli_query($link, $platformsExecutedOnQuery);
    while ($row = $platformsExecutedOnResult->fetch_array(MYSQLI_ASSOC)) {
        echo "{key: \"" . $row["browser"] . "\"},";
    }
    ?>
        {key:"Last Pass"}
        ]};

        var myColumnDefs = [
        {key:"Test ID", label:"Test ID", sortable:true},<?
    $platformsExecutedOnQuery = "select distinct  browser from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by test_id";
    $platformsExecutedOnResult = mysqli_query($link, $platformsExecutedOnQuery);

    while ($row = $platformsExecutedOnResult->fetch_array(MYSQLI_ASSOC)) {
        echo "{key:\"" . $row["browser"] . "\", label:\"" . $row["browser"] . "\", sortable:true},";
    }
    ?>
        {key:"Last Pass", label:"Last Run", sortable:true}
        ];
                var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns: true});



    </script>


</body>
</html>
