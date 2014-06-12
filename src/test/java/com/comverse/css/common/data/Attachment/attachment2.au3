Dim $Location
$Location = @ScriptDir
WinWaitActive("Choose file")  
Send($Location&"\Attachment2.txt") 
Send("{ENTER}") 







