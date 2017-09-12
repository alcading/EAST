CREATE OR REPLACE PROCEDURE REPORT.LOG_CHECK_ERROR (---，将汇总信息存放EAST_VERIF_RESULT
   p_check_row   IN EAST_RULES%ROWTYPE,
   p_errmsg      IN EAST_VERIF_RESULT.ERRORMSG%TYPE)
IS
   PRAGMA AUTONOMOUS_TRANSACTION;
   v_check_row   EAST_RULES%ROWTYPE;
   v_errmsg      EAST_VERIF_RESULT.ERRORMSG%TYPE;
   v_date        VARCHAR2 (8 CHAR) ;   --登记错误信息

     BEGIN
      v_check_row := p_check_row;
      v_errmsg    := p_errmsg;
      select to_char(sysdate,'YYYYMMDD') INTO v_date from dual;
      INSERT INTO EAST_VERIF_RESULT ( TABLE_NAME,
                                      TABLE_DESC,
                                      COLUMN_NAME,
                                      COLUMN_DESC,
                                      ERRORMSG,
                                      DATA_DATE,
                                      RULE_DESC)
           VALUES (v_check_row.TABLE_NAME1,
                   v_check_row.TABLE_DESC,
                   v_check_row.COLUMN_NAME1,
                   v_check_row.COLUMN_DESC,
                   v_errmsg,
                   v_date,
                  v_check_row.RULE_DESC);

      COMMIT;
   END LOG_CHECK_ERROR;
/