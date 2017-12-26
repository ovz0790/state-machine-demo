# state-machine-demo
Test a state machine
use profile "ifelse" for testcase with states (-Dspring.profiles.active=ifelse)

1) Start app

We can move machine to state defined by variable "definedVar". 
if it is 1 then States "C"
if it is 2 then States "D"
if it is 0 then States "E"

2) definedVar is 0 by default, use http://localhost:8080/change/var/{var}  to define it to 1/2/0

3) use http://localhost:8080/send/event/SAVE_DRAFT for make step from state "A" 
4) use http://localhost:8080/send/event/TO_START_POINT for return to state "A" 

Case 1: var = 1, go to SAVE_DRAFT and get state "C" (then back to init point before next case)
Case 2: var = 2, go to SAVE_DRAFT and get state "D" (then back to init point before next case)
Case 3: var = 0, go to SAVE_DRAFT and get state "E" (then back to init point before next case)