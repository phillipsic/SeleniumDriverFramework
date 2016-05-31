<?php
echo "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">
<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\" >";

include "./header.html";
?>
<head>
    <title>Test Result Report</title>      
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
    include "./constants.inc.php";
    include "./Mysql.obj.php";
    echo "<h2>Test Version Report</h2>";

    $DBConnection = mysqli_connect(HOST, USER, PASSWORD, DB);
//    $DBConnection->opendbconnection(HOST, DB, USER, PASSWORD);
    if (mysqli_connect_errno()) {
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }
    $RowNumberMaxLimit = 50;

    $selectedApplication = $_POST[selectedApplication];
    $selectedScript = $_POST[selectedScript];

    if (isset($_GET['selectedScript'])) {

        $selectedScript = $_GET['selectedScript'];
    }
    if (isset($_POST[selectedScript])) {

        $selectedScript = $_POST[selectedScript];
    }

    if (isset($_GET['selectedApplication'])) {

        $selectedApplication = $_GET['selectedApplication'];
    }
    if (isset($_POST[selectedApplication])) {

        $selectedApplication = $_POST[selectedApplication];
    }

    // if (isset($_GET['selectedScript'])) {
    //   $selectedScript = $_GET['selectedScript'];
    // }

    $appQuery = "SELECT distinct application from test_results;";


    $appResult = mysqli_query($DBConnection, $appQuery);

//    echo "Completed the query";

    echo "<BR>selected application is - " . $selectedApplication;
    echo "<BR>selected script  is - " . $selectedScript . "<br><br><br>";



    echo "<form name=frmTest action='versionReport.php' method=POST>";
    echo "<SELECT NAME='selectedApplication' onChange='frmTest.submit();'>";
    echo " <OPTION VALUE=\"\">Select App</OPTION>";

    while ($row = mysqli_fetch_row($appResult)) {

        echo "<OPTION VALUE='" . $row[0] . "'>" . $row[0] . "</OPTION>";
    }


    echo "</SELECT>";

    echo "</form>";




    // $selectedApplication = $_POST[selectedApplication];



    if ($selectedScript == "") {
        if ($selectedApplication != "") {

            $ListOfTestsForSelectedAppQuery = "select distinct test_id from autotest.test_results  where application = '" . $selectedApplication . "' order by test_id;";
            $ListOfTestsForSelectedAppResult = mysqli_query($DBConnection, $ListOfTestsForSelectedAppQuery);



            echo "<form name=formTest action='versionReport.php' method=POST>";
            echo "<SELECT NAME='selectedScript' onChange='formTest.submit();'>";
            echo " <OPTION VALUE=\"\">Select Script</OPTION>";

            while ($row1 = mysqli_fetch_row($ListOfTestsForSelectedAppResult)) {

                echo "<OPTION VALUE='" . $row1[0] . "'>" . $row1[0] . "</OPTION>";
            }
            echo "<input type='hidden' name='selectedApplication' value='" . $selectedApplication . "'";
            echo "</SELECT></FORM>";
        }
    } else {





        $TotalRunsPassQuery = "select count(*) as totalpass from test_results where test_id = '" . $selectedScript . "'  AND application ='" . $selectedApplication . "' and test_result = 'pass'";
        $LastPassBuildResult = mysqli_query($DBConnection, $TotalRunsPassQuery);
        $LastPassBuildArray = $LastPassBuildResult->fetch_array(MYSQLI_ASSOC);

        $TotalRunsFailQuery = "select count(*) as totalfail from test_results where test_id = '" . $selectedScript . "' AND application ='" . $selectedApplication . "' and test_result = 'fail'";
        $TotalRunsFailResult = mysqli_query($DBConnection, $TotalRunsFailQuery);
        $TotalRunsFailArray = $TotalRunsFailResult->fetch_array(MYSQLI_ASSOC);


        $LastPassBuildQuery = "select * from test_results where test_id = '" . $selectedScript . "' AND application ='" . $selectedApplication . "' and test_result = 'pass' order by id desc limit 1";
        $LastPassBuildResult = mysqli_query($DBConnection, $LastPassBuildQuery);
        $LastPassResultArray = $LastPassBuildResult->fetch_array(MYSQLI_ASSOC);

        $LastFailBuildQuery = "select * from test_results where test_id = '" . $selectedScript . "' AND application ='" . $selectedApplication . "' and test_result = 'fail' order by id desc limit 1";
        $LastFailBuildResult = mysqli_query($DBConnection, $LastFailBuildQuery);
        $LastFailResultArray = $LastFailBuildResult->fetch_array(MYSQLI_ASSOC);

        echo "<center>";
        echo "<div id=\"myMarkedUpContainer3\">";
        echo "<Table id='myTable3'><thead>";
        echo "<TR><TD>Last Pass</TD><TD> Last Fail</TD><TD>Total Pass</TD><TD> Total Fail</TD><TD> Total Run</TD></TR></thead><tbody>";
        echo "<TR>";
        echo " <TD>" . $LastPassResultArray['version'] . "</TD><TD>" . $LastFailResultArray['version'] . "</TD>";
        echo " <TD>" . $LastPassBuildArray['totalpass'] . "</TD><TD>" . $TotalRunsFailArray['totalfail'] . "</TD>";
        $totalRun = $LastPassBuildArray['totalpass'] + $TotalRunsFailArray['totalfail'];

        echo " <TD>" . $totalRun . "</TD>";
        echo "</TR>";
        echo "</tbody></Table></div>";
        echo "</center>";
        echo"<BR><BR><BR>";




        $BuildsPassQuery = "select distinct(version) from test_results where test_id = '" . $selectedScript . "' ";
        $BuildsPassQuery .= "and test_result = 'pass' AND application ='" . $selectedApplication . "' ORDER BY id DESC LIMIT " . $RowNumberMaxLimit;
        $ListPassedBuildsResult = mysqli_query($DBConnection, $BuildsPassQuery);



        echo "<h2> Last " . $RowNumberMaxLimit . " Builds test has Passed on</h2>";
        echo "<center>";
        echo "<div id=\"myMarkedUpContainer\">";
        echo "<Table id='myTable'><thead>";
        echo "<TR><TH>No</TH><TH>Build ID</TH><TH>Test Start</TH><TH>Test End</TH></TR></thead><tbody>";

        $loopCounter = 0;
        while ($row = mysqli_fetch_row($ListPassedBuildsResult)) {
            $loopCounter++;

            $BuildDatesQuery = "select min(time_stamp) as start, max(time_stamp) as end from autotest.test_results  where version = '" . $row[0] . "' ";
//            echo $BuildDatesQuery;
            $BuildDatesResult = mysqli_query($DBConnection, $BuildDatesQuery);

            $daterows = $BuildDatesResult->fetch_array(MYSQLI_ASSOC);



            echo "<TR>";
            echo "<TD>" . $loopCounter . "</TD>";
            echo "<TD>" . $row[0] . "</TD>";
            echo "<TD>" . $daterows['start'] . "</TD>";
            echo "<TD>" . $daterows['end'] . "</TD>";
        }
        echo "</TR>";
        echo "</tbody></Table></div>";
        echo "</center>";


        $TestDetailQuery = "SELECT * FROM test_results WHERE test_id ='" . $selectedScript . "' AND application ='" . $selectedApplication . "' ORDER BY id DESC LIMIT " . $RowNumberMaxLimit;
        $TestDetailResult = mysqli_query($DBConnection, $TestDetailQuery);


        echo "<h2> Last " . $RowNumberMaxLimit . " test runs</h2>";
        echo "<center>";
        echo "<div id=\"myMarkedUpContainer2\">";
        echo "<Table id='myTable2'><thead>";
        echo "<TR><TD>ID</TD><TD> Test ID</TD><TD>Application</TD><TD>Build/Version</TD><TD>Browser</TD><TD>OS</TD><TD> Time Stamp</TD><TD> Client</TD><TD>Result</TD><TD>Bug ID</TD><TD>Tag</TD></TR></thead><tbody>";


        while ($row = $TestDetailResult->fetch_array(MYSQLI_ASSOC)) {

            echo "<TR>";
            echo "<TD>" . $row['ID'] . "</TD>";
            echo "<TD>" . $row['test_id'] . "</TD>";
            echo "<TD>" . $row['application'] . "</TD>";
            echo "<TD>" . $row['version'] . "</TD>";
            echo "<TD>" . $row['browser'] . "</TD>";
            echo "<TD>" . $row['OS'] . "</TD>";
            echo "<TD>" . $row['time_stamp'] . "</TD>";
            echo "<TD>" . $row['ip'] . "</TD>";
            if ($row['test_result'] == 'fail') {
                $bgColor = "RED";
            } else {
                $bgColor = "GREEN";
            }

            echo "<TD><FONT COLOR=" . $bgColor . ">" . $row['test_result'] . "</FONT></TD>";
            echo "<TD>" . $row['bug_id'] . "</TD>";
            echo "<TD>" . $row['fail_message'] . "</TD>";
            echo "</TR>";
        }
        echo "</tbody></Table></div>";
        echo "</center>";
    }









// 
    ?>

    <script type="text/javascript">

        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable3"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "Last Pass"},
                {key: "Last Fail"},
                {key: "Total Pass"},
                {key: "Total Fail"},
                {key: "Total Run"}
            ]};

        var myColumnDefs = [
            {key: "Last Pass", label: "Last Pass", sortable: true},
            {key: "Last Fail", label: "Last Fail", sortable: true},
            {key: "Total Pass", label: "Total Pass", sortable: true},
            {key: "Total Fail", label: "Total Fail", sortable: true},
            {key: "Total Run", label: "Total Run", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer3", myColumnDefs, myDataSource, {draggableColumns: true});







        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "No"},
                {key: "Build ID"},
                {key: "Test Start"},
                {key: "Test End"}
            ]};

        var myColumnDefs = [
            {key: "No", label: "No", sortable: true},
            {key: "Build ID", label: "Build ID", sortable: true},
            {key: "Test Start", label: "Test Start", sortable: true},
            {key: "Test End", label: "Test End", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer", myColumnDefs, myDataSource, {draggableColumns: true});





        var myDataSource = new YAHOO.util.DataSource(YAHOO.util.Dom.get("myTable2"));
        myDataSource.responseType = YAHOO.util.DataSource.TYPE_HTMLTABLE;
        myDataSource.responseSchema = {
            fields: [
                {key: "ID"},
                {key: "Test ID"},
                {key: "Application"},
                {key: "Build/Version"},
                {key: "Browser"},
                {key: "OS"},
                {key: "Time Stamp"},
                {key: "Client"},
                {key: "Result"},
                {key: "Bug ID"},
                {key: "Tag"}
            ]};

        var myColumnDefs = [
            {key: "ID", label: "ID", sortable: true},
            {key: "Test ID", label: "Test ID", sortable: true},
            {key: "Application", label: "Application", sortable: true},
            {key: "Build/Version", label: "Build/Version", sortable: true},
            {key: "Browser", label: "Browser", sortable: true},
            {key: "OS", label: "OS", sortable: true},
            {key: "Time Stamp", label: "Time Stamp", sortable: true},
            {key: "Client", label: "Client", sortable: true},
            {key: "Result", label: "Result", sortable: true},
            {key: "Bug ID", label: "Bug ID", sortable: true},
            {key: "Tag", label: "Fail Message", sortable: true}
        ];


        var myDataTable = new YAHOO.widget.DataTable("myMarkedUpContainer2", myColumnDefs, myDataSource, {draggableColumns: true});

    </script>


</body>
</html>
