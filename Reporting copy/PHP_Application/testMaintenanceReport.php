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
    // $connect = ocilogon("CQ_RO", "comverse", "cqprdcbs");



    echo "<h2>Test Maintenance Report</h2>";

    include "./constants.inc.php";
    include "./Mysql.obj.php";

    function in_array_r($needle, $haystack, $strict = false) {
        foreach ($haystack as $item) {
            if (($strict ? $item === $needle : $item == $needle) || (is_array($item) && in_array_r($needle, $item, $strict))) {
                return true;
            }
        }

        return false;
    }

    $DBConnection = mysqli_connect(HOST, USER, PASSWORD, DB);

    if (mysqli_connect_errno()) {
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }







    $selectedApplication = $_POST[selectedApplication];
    $selectedBuild = $_POST[selectedBuild];

    $appQuery = "SELECT distinct application from test_results;";
    $appResult = mysqli_query($DBConnection, $appQuery);


    $LastFiveBuildsQuery = "select distinct version from autotest.test_results  order by time_stamp desc limit 15;";
    $LastFiveBuildsResult = mysqli_query($DBConnection, $LastFiveBuildsQuery);

    echo "<BR>selected application is - " . $selectedApplication;
    echo "<BR>selected build  is - " . $selectedBuild . "<br><br><br>";



    echo "<form name=frmTest action='testMaintenanceReport.php' method=POST>";
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
            $ListOfTestsForSelectedAppResult = mysqli_query($DBConnection, $ListOfTestsForSelectedAppQuery);



            echo "<form name=formTest action='testMaintenanceReport.php' method=POST>";
            echo "<SELECT NAME='selectedBuild' onChange='formTest.submit();'>";
            echo " <OPTION VALUE=\"\">Select Build</OPTION>";

            while ($row1 = mysqli_fetch_row($ListOfTestsForSelectedAppResult)) {

                echo "<OPTION VALUE='" . $row1[0] . "'>" . $row1[0] . "</OPTION>";
            }
            echo "<input type='hidden' name='selectedApplication' value='" . $selectedApplication . "'";
            echo "</SELECT></FORM>";
        }
    } else {


//    if ($selectedApplication != "" && $selectedBuild != "") {



        $ListOfAllResultsQuery = "select  distinct test_id, test_result, bug_id, fail_message from test_results where application = '" . $selectedApplication . "' and version = '" . $selectedBuild . "' order by test_id, time_stamp DESC";

        // echo "executing: " . $ListOfAllResultsQuery;

        $ListOfAllResultsResult = mysqli_query($DBConnection, $ListOfAllResultsQuery);
        $currentTestId = null;
        $listOfPassedTests = array();
        $listOfFailedTests = array();
        $listOfFailedTestsWithBugs = array();

        while ($row = $ListOfAllResultsResult->fetch_array(MYSQLI_ASSOC)) {

            if ($row['test_result'] == 'pass') {

                $listOfPassedTests[] = $row['test_id'];
            }
        }

        //var_dump($listOfPassedTests);


        mysqli_data_seek($ListOfAllResultsResult, 0);
        while ($row = $ListOfAllResultsResult->fetch_array(MYSQLI_ASSOC)) {
            if (in_array($row['test_id'], $listOfPassedTests)) {

                // echo "<BR>Found result for " . $row['test_id'] . " DO NOTHING";
            } else {

                // echo "<BR>Found no result for " . $row['test_id'] . " DO SOMETHING";


                if ($row['bug_id'] != 'NoBug') {

                    if (in_array_r($row['test_id'], $listOfFailedTestsWithBugs)) {
                        
                    } else {
                        $listOfFailedTestsWithBugs[] = array($row['test_id'], $row['bug_id']);
                    }
                } else {

                    if (in_array_r($row['test_id'], $listOfFailedTests)) {
                        
                    } else {

                        // var_dump($listOfFailedTests);
                        // echo "<BR>_________________________________<BR><BR>";
                        // echo $row['test_id'];
                        // echo "<BR>_________________________________<BR><BR>";
                        //  echo  $row['test_id'] . " -- ". $row['fail_message'];
                        //  echo "<BR>_________________________________<BR><BR>";

                        $listOfFailedTests[] = array($row['test_id'], $row['bug_id'], $row['fail_message']);
                    }
                }
            }
        }


        // var_dump($listOfFailedTestsWithBugs);
// check if test is failing with bug id and remove from failed tests
        foreach ($listOfFailedTests as $key => $value) {
            //echo "<BR><BR>checking " . $value[0] . " for BUG ID" . $key;

            $testFound = FALSE;
            foreach ($listOfFailedTestsWithBugs as $key2 => $value2) {

                // echo "<BR><BR>Comparing " . $value[0] . "  with " . $value2[0];
                if ($value2[0] == $value[0])
                    $testFound = TRUE;
            }

            if (!$testFound) {
                $newListOfFailedTests[] = array($value[0], $value[2]);
            }
        }
        //echo "<BR>_________________________________<BR><BR>";
        // var_dump($listOfFailedTests);
        // echo "<BR>_________________________________<BR><BR>";
        // var_dump($newListOfFailedTests);
        //  echo "<BR>_________________________________<BR><BR>";
        // var_dump($listOfFailedTestsWithBugs);
        // echo "<BR>_________________________________<BR><BR>";


        echo "<center>";
        echo "<div id=\"myMarkedUpContainer\">";
        echo "<Table id='myTable'><thead>";
        echo "<TR><TH>Test ID</TH><th>Last Pass</TH></TR></thead><tbody>";

        reset($newListOfFailedTests);

        //  var_dump($newListOfFailedTests);

        foreach ($newListOfFailedTests as $key => $value) {

            // echo " value => " . $value[0];

            $PassQuery = "select * from test_results where test_id = '" . $value[0] . "'  and test_result = 'pass' AND application = '" . $selectedApplication . "' group by id desc limit 1";
            // echo " executing ==> " . $PassQuery;
            $PassResult = mysqli_query($DBConnection, $PassQuery);
            $passrow = $PassResult->fetch_array(MYSQLI_ASSOC);





            echo "<TR>";
            echo "<TD><a href='versionReport.php?selectedScript=" . urlencode($value[0]) . "&selectedApplication=" . $selectedApplication . "'>" . $value[0] . "</a> </TD>";
            echo "<TD>" . $passrow['version'] . "</TD>";
            echo "<TD>" . $value[1] . "</TD>";
            echo "</TR>";
        }


        echo "</tbody></Table ></div>";
        echo "<center>";

        echo "<h2>Test scripts failing with a defect</h2>";
        $DefectIDSQL = " SELECT  distinct test_id, bug_id FROM autotest.test_results WHERE  test_result != 'pass' and bug_id !='NoBug' and version like ('%" . $selectedBuild . "%') and application = '" . $selectedApplication . "'";

        $DefectIDResult = mysqli_query($DBConnection, $DefectIDSQL);
        echo "<div id=\"my2MarkedUpContainer\">";
        echo "<Table id='my2Table'><thead>";
        echo "<TR><TH>Test ID</TH><TH>Bug ID</TH></TR></thead><tbody>";

        foreach ($listOfFailedTestsWithBugs as $key => $value) {
            echo "<BR>" . $stmt;
            echo "<TR>";
            echo "<TD>" . $value[0] . "</td><td>" . $value[1] . " </TD>";
            echo "</TR>";
        }


        echo "</tbody></Table ></div>";
    }
    // 
    ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "Test ID"},
                {key: "Last Pass"},
                {key: "Last Fail Message"}
            ]};

        var myColumnDefs = [
            {key: "Test ID", label: "Test ID", sortable: true},
            {key: "Last Pass", label: "Last Pass", sortable: true},
            {key: "Last Fail Message", label: "Last Fail Message", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns: true});


        var my2DataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("my2Table"));
        my2DataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        my2DataSource.responseSchema = {
            fields: [
                {key: "Test ID"},
                {key: "Bug ID"}

            ]};

        var my2ColumnDefs = [
            {key: "Test ID", label: "Test ID", sortable: true},
            {key: "Bug ID", label: "Bug ID", sortable: true}

        ];


        var my2DataTable = new YAHOO.widget.DataTable("my2MarkedUpContainer", my2ColumnDefs, my2DataSource, {draggableColumns: true});


    </script>


</body>
</html>
