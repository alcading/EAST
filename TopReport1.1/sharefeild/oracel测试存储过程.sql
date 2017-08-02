CREATE OR REPLACE procedure L_TOPREPORT.test_analy(
 workdate in varchar2,
 busitype in varchar2,
 apptype in varchar2,
 analyno in varchar2,
 ret_cursor out sys_refcursor
)is
ret_cursor_value  sys_refcursor;
begin
dbms_output.put_line(analyno);
open ret_cursor_value for select ap.* from BI_ANALY_PROCESS ap;
ret_cursor:=ret_cursor_value;
end test_analy;
