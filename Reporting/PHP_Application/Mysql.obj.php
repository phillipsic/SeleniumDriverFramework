<?php

/**
#
 * FileName Revision Date Author
 #
*$Id$
#
  * @package DataSource
#
 */
#
// 

#
/**
#
 * This is the mysql Class
#
 * This class is used to connect and disconnect to mysql
#
 * @package DataSource
#
 * @subpackage Mysql
#
 */
class mysql {


	/**
	 * opendbconnection - Creates a connection to the mysql database
	 *  The parameters are set in a contants file, not in the page.
	 *
	 *<code>
	 * $result = $dbConnection->opendbconnection($HOST, $DB, $USER, $PASSWORD) ;
	 *</code>
	 *
	 * @param string $HOST - MySQL host
	 * @param string $DB - the name of the database
	 * @param string $USER - user to connect with
	 * @param string $PASSWORD - connecting users password
	 * @return connection 
	 */	

	function opendbconnection($HOST, $DB, $USER, $PASSWORD) {
	
		
		 $this->dbconnection = mysqli_connect($HOST, $USER, $PASSWORD, $DB) or die("Error " . mysqli_error( $this->dbconnection));
		 
		
//		 if ( $this->dbconnection ) {
//			 $this->db = mysql_select_db($DB);
//			 
//			 if ( !$this->db ) {
//					// @codeCoverageIgnoreStart
//					return mysql_errno()." - ".mysql_error();
//					// @codeCoverageIgnoreEnd
//			}
//			 
//		 } else {
//			 
//			 // @codeCoverageIgnoreStart
//			 return mysql_errno()." - ".mysql_error();
//			 // @codeCoverageIgnoreEnd
//		 }
//		 
		 return $this->dbconnection;

		
    }
	
	/**
	 * closedbconnection -closes a connection to the mysql database
	 *
	 *<code>
	 * $dbConnection->closedbconnection();
	 *</code>
	 *
	*/	
	
	function closedbconnection() {
		
		
         #if ($this->dbconnection = TRUE) {
             mysql_close($this->dbconnection);
         #}
                
    }
}

?>
