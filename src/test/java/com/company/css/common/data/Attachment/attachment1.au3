Dim $Location
$Location = @ScriptDir
WinWaitActive("Choose file")  
Send($Location&"\Attachment1.txt") 
Send("{ENTER}") 







