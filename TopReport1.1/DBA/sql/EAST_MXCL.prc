CREATE OR REPLACE PROCEDURE REPORT.EAST_MXCL (
   P_TBNAME   IN EAST_RULES.TABLE_NAME1%TYPE,
   P_SQL      IN VARCHAR2,
   P_ERRMSG      EAST_VERIF_RESULT.ERRORMSG%TYPE)
AS
   V_EXCEMSG   EAST_PROCESS_LOG.EXCEMSG%TYPE;
   TYPE CUR_TYPE IS REF CURSOR;

   CUR_TMP                     CUR_TYPE;
   V_LIMT                      NUMBER;
   V_CNT                       NUMBER;

   TYPE TB_EAST_YGB IS TABLE OF EAST_YGB%ROWTYPE;

   TB_EAST_YGB_REC             TB_EAST_YGB;

   TYPE TB_EAST_CZXX IS TABLE OF EAST_CZXX%ROWTYPE;        -- EAST_CZXX---存折信息

   TB_EAST_CZXX_REC            TB_EAST_CZXX;

   TYPE TB_EAST_DBGX IS TABLE OF EAST_DBGX%ROWTYPE;         --EAST_DBGX---担保关系

   TB_EAST_DBGX_REC            TB_EAST_DBGX;

   TYPE TB_EAST_DGBWSXYW IS TABLE OF EAST_DGBWSXYW%ROWTYPE; --EAST_DGBWSXYW---表外授信业务

   TB_EAST_DGBWSXYW_REC        TB_EAST_DGBWSXYW;

   TYPE TB_EAST_DGDQCKFHZ IS TABLE OF EAST_DGDQCKFHZ%ROWTYPE; --EAST_DGDQCKFHZ---对公定期存款分户账

   TB_EAST_DGDQCKFHZ_REC       TB_EAST_DGDQCKFHZ;

   TYPE TB_EAST_DGDQCKFHZMXJL IS TABLE OF EAST_DGDQCKFHZMXJL%ROWTYPE; --EAST_DGDQCKFHZMXJL---对公定期存款分户账明细记录

   TB_EAST_DGDQCKFHZMXJL_REC   TB_EAST_DGDQCKFHZMXJL;

   TYPE TB_EAST_DGHQCKFHZ IS TABLE OF EAST_DGHQCKFHZ%ROWTYPE; --EAST_DGHQCKFHZ---对公活期存款分户账

   TB_EAST_DGHQCKFHZ_REC       TB_EAST_DGHQCKFHZ;

   TYPE TB_EAST_DGHQCKFHZMXJL IS TABLE OF EAST_DGHQCKFHZMXJL%ROWTYPE; --EAST_DGHQCKFHZMXJL---对公活期存款分户账明细记录

   TB_EAST_DGHQCKFHZMXJL_REC   TB_EAST_DGHQCKFHZMXJL;

   TYPE TB_EAST_DGKH IS TABLE OF EAST_DGKH%ROWTYPE;         --EAST_DGKH---对公客户

   TB_EAST_DGKH_REC            TB_EAST_DGKH;

   TYPE TB_EAST_DGXDFHZ IS TABLE OF EAST_DGXDFHZ%ROWTYPE; --EAST_DGXDFHZ---对公信贷分户账

   TB_EAST_DGXDFHZ_REC         TB_EAST_DGXDFHZ;

   TYPE TB_EAST_DGXDFHZMXJL IS TABLE OF EAST_DGXDFHZMXJL%ROWTYPE; --EAST_DGXDFHZMXJL---对公信贷分户账明细记录

   TB_EAST_DGXDFHZMXJL_REC     TB_EAST_DGXDFHZMXJL;

   TYPE TB_EAST_DGXDYWJJ IS TABLE OF EAST_DGXDYWJJ%ROWTYPE; --EAST_DGXDYWJJ---对公信贷业务借据

   TB_EAST_DGXDYWJJ_REC        TB_EAST_DGXDYWJJ;

   TYPE TB_EAST_DKHX IS TABLE OF EAST_DKHX%ROWTYPE;         --EAST_DKHX---贷款核销

   TB_EAST_DKHX_REC            TB_EAST_DKHX;

   TYPE TB_EAST_DKWJXTBD IS TABLE OF EAST_DKWJXTBD%ROWTYPE; --EAST_DKWJXTBD---贷款五级形态变动

   TB_EAST_DKWJXTBD_REC        TB_EAST_DKWJXTBD;

   TYPE TB_EAST_DKZQ IS TABLE OF EAST_DKZQ%ROWTYPE;         --EAST_DKZQ---贷款展期

   TB_EAST_DKZQ_REC            TB_EAST_DKZQ;

   TYPE TB_EAST_GDXX IS TABLE OF EAST_GDXX%ROWTYPE;         --EAST_GDXX---股东信息

   TB_EAST_GDXX_REC            TB_EAST_GDXX;

   TYPE TB_EAST_GLGX IS TABLE OF EAST_GLGX%ROWTYPE;         --EAST_GLGX---关联关系

   TB_EAST_GLGX_REC            TB_EAST_GLGX;

   TYPE TB_EAST_GRDQCKFHZ IS TABLE OF EAST_GRDQCKFHZ%ROWTYPE; --EAST_GRDQCKFHZ---个人定期存款分户账

   TB_EAST_GRDQCKFHZ_REC       TB_EAST_GRDQCKFHZ;

   TYPE TB_EAST_GRDQCKFHZMXJL IS TABLE OF EAST_GRDQCKFHZMXJL%ROWTYPE; --EAST_GRDQCKFHZMXJL---个人定期存款分户账明细记录

   TB_EAST_GRDQCKFHZMXJL_REC   TB_EAST_GRDQCKFHZMXJL;

   TYPE TB_EAST_GRHQCKFHZ IS TABLE OF EAST_GRHQCKFHZ%ROWTYPE; --EAST_GRHQCKFHZ---个人活期存款分户账

   TB_EAST_GRHQCKFHZ_REC       TB_EAST_GRHQCKFHZ;

   TYPE TB_EAST_GRHQCKFHZMXJL IS TABLE OF EAST_GRHQCKFHZMXJL%ROWTYPE; --EAST_GRHQCKFHZMXJL---个人活期存款分户账明细记录

   TB_EAST_GRHQCKFHZMXJL_REC   TB_EAST_GRHQCKFHZMXJL;

   TYPE TB_EAST_GRJCXX IS TABLE OF EAST_GRJCXX%ROWTYPE; --EAST_GRJCXX---个人基础信息

   TB_EAST_GRJCXX_REC          TB_EAST_GRJCXX;

   TYPE TB_EAST_GRKHGXXX IS TABLE OF EAST_GRKHGXXX%ROWTYPE; --EAST_GRKHGXXX---个人客户关系信息

   TB_EAST_GRKHGXXX_REC        TB_EAST_GRKHGXXX;

   TYPE TB_EAST_GRXDFHZ IS TABLE OF EAST_GRXDFHZ%ROWTYPE; --EAST_GRXDFHZ---个人信贷分户账

   TB_EAST_GRXDFHZ_REC         TB_EAST_GRXDFHZ;

   TYPE TB_EAST_GRXDFHZMXJL IS TABLE OF EAST_GRXDFHZMXJL%ROWTYPE; --EAST_GRXDFHZMXJL---个人信贷分户账明细记录

   TB_EAST_GRXDFHZMXJL_REC     TB_EAST_GRXDFHZMXJL;

   TYPE TB_EAST_GRXDYWJJ IS TABLE OF EAST_GRXDYWJJ%ROWTYPE; --EAST_GRXDYWJJ---个人信贷业务借据

   TB_EAST_GRXDYWJJ_REC        TB_EAST_GRXDYWJJ;

   TYPE TB_EAST_GWXXB IS TABLE OF EAST_GWXXB%ROWTYPE;     --EAST_GWXXB---岗位信息表

   TB_EAST_GWXXB_REC           TB_EAST_GWXXB;

   TYPE TB_EAST_GYB IS TABLE OF EAST_GYB%ROWTYPE;             --EAST_GYB---柜员表

   TB_EAST_GYB_REC             TB_EAST_GYB;

   TYPE TB_EAST_HLXXB IS TABLE OF EAST_HLXXB%ROWTYPE;     --EAST_HLXXB---汇率信息表

   TB_EAST_HLXXB_REC           TB_EAST_HLXXB;

   TYPE TB_EAST_JGGXB IS TABLE OF EAST_JGGXB%ROWTYPE;     --EAST_JGGXB---机构关系表

   TB_EAST_JGGXB_REC           TB_EAST_JGGXB;

   TYPE TB_EAST_JJKXX IS TABLE OF EAST_JJKXX%ROWTYPE;     --EAST_JJKXX---借记卡信息

   TB_EAST_JJKXX_REC           TB_EAST_JJKXX;

   TYPE TB_EAST_JRGJXXB IS TABLE OF EAST_JRGJXXB%ROWTYPE; ---EAST_JRGJXXB--金融工具信息表

   TB_EAST_JRGJXXB_REC         TB_EAST_JRGJXXB;

   TYPE TB_EAST_JYLS IS TABLE OF EAST_JYLS%ROWTYPE;        ---EAST_JYLS---交易流水

   TB_EAST_JYLS_REC            TB_EAST_JYLS;

   TYPE TB_EAST_KHLCZHXXB IS TABLE OF EAST_KHLCZHXXB%ROWTYPE; ---EAST_KHLCZHXXB---客户理财账户信息表

   TB_EAST_KHLCZHXXB_REC       TB_EAST_KHLCZHXXB;

   TYPE TB_EAST_LCCPXSMX IS TABLE OF EAST_LCCPXSMX%ROWTYPE; ---EAST_LCCPXSMX---理财产品销售明细记录

   TB_EAST_LCCPXSMX_REC        TB_EAST_LCCPXSMX;

   TYPE TB_EAST_LCCPXXB IS TABLE OF EAST_LCCPXXB%ROWTYPE; ---EAST_LCCPXXB---理财产品信息表

   TB_EAST_LCCPXXB_REC         TB_EAST_LCCPXXB;

   TYPE TB_EAST_LCCPZTB IS TABLE OF EAST_LCCPZTB%ROWTYPE; ---EAST_LCCPZTB---理财产品状态表

   TB_EAST_LCCPZTB_REC         TB_EAST_LCCPZTB;

   TYPE TB_EAST_MYRZYWXXB IS TABLE OF EAST_MYRZYWXXB%ROWTYPE; ---EAST_MYRZYWXXB---贸易融资业务信息表

   TB_EAST_MYRZYWXXB_REC       TB_EAST_MYRZYWXXB;

   TYPE TB_EAST_NBFHZ IS TABLE OF EAST_NBFHZ%ROWTYPE;    ---EAST_NBFHZ---内部分户账

   TB_EAST_NBFHZ_REC           TB_EAST_NBFHZ;

   TYPE TB_EAST_NBFHZMXJL IS TABLE OF EAST_NBFHZMXJL%ROWTYPE; ---EAST_NBFHZMXJL---内部分户账明细记录

   TB_EAST_NBFHZMXJL_REC       TB_EAST_NBFHZMXJL;

   TYPE TB_EAST_NBKMDZB IS TABLE OF EAST_NBKMDZB%ROWTYPE; ---EAST_NBKMDZB---内部科目对照表

   TB_EAST_NBKMDZB_REC         TB_EAST_NBKMDZB;

   TYPE TB_EAST_PJPMXXB IS TABLE OF EAST_PJPMXXB%ROWTYPE; ---EAST_PJPMXXB---票据票面信息表

   TB_EAST_PJPMXXB_REC         TB_EAST_PJPMXXB;

   TYPE TB_EAST_SNTJB IS TABLE OF EAST_SNTJB%ROWTYPE;    ---EAST_SNTJB---涉农统计表

   TB_EAST_SNTJB_REC           TB_EAST_SNTJB;

   TYPE TB_EAST_SXXX IS TABLE OF EAST_SXXX%ROWTYPE;        ---EAST_SXXX---授信信息

   TB_EAST_SXXX_REC            TB_EAST_SXXX;

   TYPE TB_EAST_WTDK IS TABLE OF EAST_WTDK%ROWTYPE;        ---EAST_WTDK---委托贷款

   TB_EAST_WTDK_REC            TB_EAST_WTDK;

   TYPE TB_EAST_XDHTB IS TABLE OF EAST_XDHTB%ROWTYPE;    ---EAST_XDHTB---信贷合同表

   TB_EAST_XDHTB_REC           TB_EAST_XDHTB;

   TYPE TB_EAST_XDYWDBHT IS TABLE OF EAST_XDYWDBHT%ROWTYPE; ---- EAST_XDYWDBHT---信贷业务担保合同

   TB_EAST_XDYWDBHT_REC        TB_EAST_XDYWDBHT;

   TYPE TB_EAST_XDYWZHDYW IS TABLE OF EAST_XDYWZHDYW%ROWTYPE; ---- EAST_XDYWZHDYW---信贷业务质或抵押物

   TB_EAST_XDYWZHDYW_REC       TB_EAST_XDYWZHDYW;

   TYPE TB_EAST_XDZCZR IS TABLE OF EAST_XDZCZR%ROWTYPE; ---- EAST_XDZCZR---信贷资产转让

   TB_EAST_XDZCZR_REC          TB_EAST_XDZCZR;

   TYPE TB_EAST_XMDKXXB IS TABLE OF EAST_XMDKXXB%ROWTYPE; ---- EAST_XMDKXXB---项目贷款信息表

   TB_EAST_XMDKXXB_REC         TB_EAST_XMDKXXB;

   TYPE TB_EAST_XYKXX IS TABLE OF EAST_XYKXX%ROWTYPE;  ---- EAST_XYKXX---信用卡信息

   TB_EAST_XYKXX_REC           TB_EAST_XYKXX;

   TYPE TB_EAST_XYKZHJYMXB IS TABLE OF EAST_XYKZHJYMXB%ROWTYPE; ---- EAST_XYKZHJYMXB---信用卡账户交易明细记录

   TB_EAST_XYKZHJYMXB_REC      TB_EAST_XYKZHJYMXB;

   TYPE TB_EAST_YTDK IS TABLE OF EAST_YTDK%ROWTYPE;      ---- EAST_YTDK---银团贷款

   TB_EAST_YTDK_REC            TB_EAST_YTDK;

   TYPE TB_EAST_ZCFZKMTJB IS TABLE OF EAST_ZCFZKMTJB%ROWTYPE; ---- EAST_ZCFZKMTJB---资产负债科目统计表

   TB_EAST_ZCFZKMTJB_REC       TB_EAST_ZCFZKMTJB;

   TYPE TB_EAST_ZCZRGXB IS TABLE OF EAST_ZCZRGXB%ROWTYPE; ----EAST_ZCZRGXB---资产转让关系表

   TB_EAST_ZCZRGXB_REC         TB_EAST_ZCZRGXB;

   TYPE TB_EAST_ZJJYXXB IS TABLE OF EAST_ZJJYXXB%ROWTYPE; ----EAST_ZJJYXXB---资金交易信息表

   TB_EAST_ZJJYXXB_REC         TB_EAST_ZJJYXXB;

   TYPE TB_EAST_ZZHJQKMB IS TABLE OF EAST_ZZHJQKMB%ROWTYPE; ----EAST_ZZHJQKMB---总账会计全科目表

   TB_EAST_ZZHJQKMB_REC        TB_EAST_ZZHJQKMB;

   TYPE TB_EAST_JGXXB IS TABLE OF EAST_JGXXB%ROWTYPE;   ----EAST_JGXXB---机构信息表

   TB_EAST_JGXXB_REC           TB_EAST_JGXXB;
BEGIN
   V_LIMT := 100;
   DBMS_OUTPUT.PUT_LINE (P_TBNAME||'----'||P_SQL);
   OPEN CUR_TMP FOR P_SQL;
 ---EAST_YGB --员工表 1
   IF P_TBNAME = 'EAST_YGB'                                              --员工表
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_YGB_REC
         LIMIT V_LIMT;

      FOR I IN TB_EAST_YGB_REC.FIRST .. TB_EAST_YGB_REC.LAST
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_YGB_TMP
          WHERE     GH = TB_EAST_YGB_REC (I).GH
                AND NBJGH = TB_EAST_YGB_REC (I).NBJGH;

         IF V_CNT > 0
         THEN
            UPDATE EAST_YGB_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.GH = TB_EAST_YGB_REC (I).GH
                   AND TP.NBJGH = TB_EAST_YGB_REC (I).NBJGH;
         ELSE
            INSERT INTO EAST_YGB_TMP
                 VALUES (TB_EAST_YGB_REC (I).GH,
                         TB_EAST_YGB_REC (I).YXJGDM,
                         TB_EAST_YGB_REC (I).NBJGH,
                         TB_EAST_YGB_REC (I).JRXKZH,
                         TB_EAST_YGB_REC (I).YXJGMC,
                         TB_EAST_YGB_REC (I).XM,
                         TB_EAST_YGB_REC (I).SFZH,
                         TB_EAST_YGB_REC (I).LXDH,
                         TB_EAST_YGB_REC (I).WDH,
                         TB_EAST_YGB_REC (I).SSBM,
                         TB_EAST_YGB_REC (I).ZW,
                         TB_EAST_YGB_REC (I).YGZT,
                         TB_EAST_YGB_REC (I).GWBH,
                         TB_EAST_YGB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
--   ----存折信息 2   
   ELSIF P_TBNAME = 'EAST_CZXX'                                      
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_CZXX_REC
         LIMIT V_LIMT;

      FOR I IN TB_EAST_CZXX_REC.FIRST .. TB_EAST_CZXX_REC.LAST
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_CZXX_TMP
          WHERE     CZH = TB_EAST_CZXX_REC (I).CZH
                AND CJRQ = TB_EAST_CZXX_REC (I).CJRQ;

         IF V_CNT > 0
         THEN
            UPDATE EAST_CZXX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.CZH = TB_EAST_CZXX_REC (I).CZH
                   AND TP.CJRQ = TB_EAST_CZXX_REC (I).CJRQ;
         ELSE
            INSERT INTO REPORT.EAST_CZXX_TMP (CZH,
                                              HQCKZH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              ZJLB,
                                              ZJHM,
                                              CZLX,
                                              CZZT,
                                              YGBZ,
                                              QYRQ,
                                              QYGYH,
                                              ERRMSG,
                                              CJRQ)
                 VALUES (TB_EAST_CZXX_REC (I).CZH,
                         TB_EAST_CZXX_REC (I).HQCKZH,
                         TB_EAST_CZXX_REC (I).KHTYBH,
                         TB_EAST_CZXX_REC (I).YXJGDM,
                         TB_EAST_CZXX_REC (I).JRXKZH,
                         TB_EAST_CZXX_REC (I).NBJGH,
                         TB_EAST_CZXX_REC (I).ZJLB,
                         TB_EAST_CZXX_REC (I).ZJHM,
                         TB_EAST_CZXX_REC (I).CZLX,
                         TB_EAST_CZXX_REC (I).CZZT,
                         TB_EAST_CZXX_REC (I).YGBZ,
                         TB_EAST_CZXX_REC (I).QYRQ,
                         TB_EAST_CZXX_REC (I).QYGYH,
                         P_ERRMSG,
                         TB_EAST_CZXX_REC (I).CJRQ);
         END IF;
      END LOOP;

      COMMIT;
       --EAST_DBGX---担保关系3
   ELSIF P_TBNAME = 'EAST_DBGX'                            
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DBGX_REC
         LIMIT V_LIMT;

      FOR I IN TB_EAST_DBGX_REC.FIRST .. TB_EAST_DBGX_REC.LAST
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DBGX_TMP
          WHERE     DBHTH = TB_EAST_DBGX_REC (I).DBHTH
                AND BDBHTH = TB_EAST_DBGX_REC (I).BDBHTH
                AND CJRQ = TB_EAST_DBGX_REC (I).CJRQ;

         IF V_CNT > 0
         THEN
            UPDATE EAST_DBGX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DBHTH = TB_EAST_DBGX_REC (I).DBHTH
                   AND TP.BDBHTH = TB_EAST_DBGX_REC (I).BDBHTH
                   AND TP.CJRQ = TB_EAST_DBGX_REC (I).CJRQ;
         ELSE
            INSERT INTO REPORT.EAST_DBGX_TMP (DBHTH,
                                              BDBHTH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              DBLX,
                                              DBJE,
                                              DBQSRQ,
                                              DBDQRQ,
                                              DBZT,
                                              JLDBYGH,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_DBGX_REC (I).DBHTH,
                         TB_EAST_DBGX_REC (I).BDBHTH,
                         TB_EAST_DBGX_REC (I).YXJGDM,
                         TB_EAST_DBGX_REC (I).JRXKZH,
                         TB_EAST_DBGX_REC (I).NBJGH,
                         TB_EAST_DBGX_REC (I).DBLX,
                         TB_EAST_DBGX_REC (I).DBJE,
                         TB_EAST_DBGX_REC (I).DBQSRQ,
                         TB_EAST_DBGX_REC (I).DBDQRQ,
                         TB_EAST_DBGX_REC (I).DBZT,
                         TB_EAST_DBGX_REC (I).JLDBYGH,
                         TB_EAST_DBGX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
      -- -----表外授信业务 4
   ELSIF P_TBNAME = 'EAST_DGBWSXYW'                             
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGBWSXYW_REC
         LIMIT V_LIMT;

      FOR I IN TB_EAST_DGBWSXYW_REC.FIRST .. TB_EAST_DGBWSXYW_REC.LAST
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGBWSXYW_TMP
          WHERE     XDJJH = TB_EAST_DGBWSXYW_REC (I).XDJJH
                AND CJRQ = TB_EAST_DGBWSXYW_REC (I).CJRQ;

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGBWSXYW_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.XDJJH = TB_EAST_DGBWSXYW_REC (I).XDJJH
                   AND TP.CJRQ = TB_EAST_DGBWSXYW_REC (I).CJRQ;
         ELSE
            INSERT INTO REPORT.EAST_DGBWSXYW_TMP (XDJJH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  KHTYBH,
                                                  KHMC,
                                                  XDHTH,
                                                  YXJGMC,
                                                  MXKMBH,
                                                  MXKMMC,
                                                  BWYWPZ,
                                                  BZ,
                                                  JE,
                                                  YE,
                                                  DKQX,
                                                  SFDF,
                                                  DKSJFFRQ,
                                                  DKYSDQRQ,
                                                  DKSJDQRQ,
                                                  ZJRQ,
                                                  DKWJFL,
                                                  SXFJE,
                                                  BZJBL,
                                                  BZJBZ,
                                                  BZJJE,
                                                  BZJZH,
                                                  PJHM,
                                                  PMJE,
                                                  SYFPHM,
                                                  SYFPBZ,
                                                  SYFPJE,
                                                  SYFPZL,
                                                  XDYGH,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_DGBWSXYW_REC (I).XDJJH,
                         TB_EAST_DGBWSXYW_REC (I).YXJGDM,
                         TB_EAST_DGBWSXYW_REC (I).JRXKZH,
                         TB_EAST_DGBWSXYW_REC (I).NBJGH,
                         TB_EAST_DGBWSXYW_REC (I).KHTYBH,
                         TB_EAST_DGBWSXYW_REC (I).KHMC,
                         TB_EAST_DGBWSXYW_REC (I).XDHTH,
                         TB_EAST_DGBWSXYW_REC (I).YXJGMC,
                         TB_EAST_DGBWSXYW_REC (I).MXKMBH,
                         TB_EAST_DGBWSXYW_REC (I).MXKMMC,
                         TB_EAST_DGBWSXYW_REC (I).BWYWPZ,
                         TB_EAST_DGBWSXYW_REC (I).BZ,
                         TB_EAST_DGBWSXYW_REC (I).JE,
                         TB_EAST_DGBWSXYW_REC (I).YE,
                         TB_EAST_DGBWSXYW_REC (I).DKQX,
                         TB_EAST_DGBWSXYW_REC (I).SFDF,
                         TB_EAST_DGBWSXYW_REC (I).DKSJFFRQ,
                         TB_EAST_DGBWSXYW_REC (I).DKYSDQRQ,
                         TB_EAST_DGBWSXYW_REC (I).DKSJDQRQ,
                         TB_EAST_DGBWSXYW_REC (I).ZJRQ,
                         TB_EAST_DGBWSXYW_REC (I).DKWJFL,
                         TB_EAST_DGBWSXYW_REC (I).SXFJE,
                         TB_EAST_DGBWSXYW_REC (I).BZJBL,
                         TB_EAST_DGBWSXYW_REC (I).BZJBZ,
                         TB_EAST_DGBWSXYW_REC (I).BZJJE,
                         TB_EAST_DGBWSXYW_REC (I).BZJZH,
                         TB_EAST_DGBWSXYW_REC (I).PJHM,
                         TB_EAST_DGBWSXYW_REC (I).PMJE,
                         TB_EAST_DGBWSXYW_REC (I).SYFPHM,
                         TB_EAST_DGBWSXYW_REC (I).SYFPBZ,
                         TB_EAST_DGBWSXYW_REC (I).SYFPJE,
                         TB_EAST_DGBWSXYW_REC (I).SYFPZL,
                         TB_EAST_DGBWSXYW_REC (I).XDYGH,
                         TB_EAST_DGBWSXYW_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGDQCKFHZ'                            -----对公定期存款分户账5
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGDQCKFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGDQCKFHZ_REC.COUNT --TB_EAST_DGDQCKFHZ_REC.FIRST .. TB_EAST_DGDQCKFHZ_REC.LAST
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGDQCKFHZ_TMP
          WHERE     DQCKZH = TB_EAST_DGDQCKFHZ_REC (I).DQCKZH
                AND BZ = TB_EAST_DGDQCKFHZ_REC (I).BZ
                AND CHLB = TB_EAST_DGDQCKFHZ_REC (I).CHLB
                AND CJRQ = TB_EAST_DGDQCKFHZ_REC (I).CJRQ; -- (DQCKZH, BZ, CHLB, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGDQCKFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DQCKZH = TB_EAST_DGDQCKFHZ_REC (I).DQCKZH
                   AND TP.BZ = TB_EAST_DGDQCKFHZ_REC (I).BZ
                   AND TP.CHLB = TB_EAST_DGDQCKFHZ_REC (I).CHLB
                   AND TP.CJRQ = TB_EAST_DGDQCKFHZ_REC (I).CJRQ; -- (DQCKZH, BZ, CHLB, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGDQCKFHZ_TMP (DQCKZH,
                                                   KHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   MXKMMC,
                                                   YXJGMC,
                                                   BZ,
                                                   TJKMBH,
                                                   ZHMC,
                                                   DGDQCKZHLX,
                                                   CKQX,
                                                   LL,
                                                   BZJZHBZ,
                                                   KHJE,
                                                   CKYE,
                                                   KHRQ,
                                                   KHGYH,
                                                   XHRQ,
                                                   DQR,
                                                   ZHZT,
                                                   SCDHRQ,
                                                   CHLB,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_DGDQCKFHZ_REC (I).DQCKZH,
                         TB_EAST_DGDQCKFHZ_REC (I).KHTYBH,
                         TB_EAST_DGDQCKFHZ_REC (I).YXJGDM,
                         TB_EAST_DGDQCKFHZ_REC (I).JRXKZH,
                         TB_EAST_DGDQCKFHZ_REC (I).NBJGH,
                         TB_EAST_DGDQCKFHZ_REC (I).MXKMBH,
                         TB_EAST_DGDQCKFHZ_REC (I).MXKMMC,
                         TB_EAST_DGDQCKFHZ_REC (I).YXJGMC,
                         TB_EAST_DGDQCKFHZ_REC (I).BZ,
                         TB_EAST_DGDQCKFHZ_REC (I).TJKMBH,
                         TB_EAST_DGDQCKFHZ_REC (I).ZHMC,
                         TB_EAST_DGDQCKFHZ_REC (I).DGDQCKZHLX,
                         TB_EAST_DGDQCKFHZ_REC (I).CKQX,
                         TB_EAST_DGDQCKFHZ_REC (I).LL,
                         TB_EAST_DGDQCKFHZ_REC (I).BZJZHBZ,
                         TB_EAST_DGDQCKFHZ_REC (I).KHJE,
                         TB_EAST_DGDQCKFHZ_REC (I).CKYE,
                         TB_EAST_DGDQCKFHZ_REC (I).KHRQ,
                         TB_EAST_DGDQCKFHZ_REC (I).KHGYH,
                         TB_EAST_DGDQCKFHZ_REC (I).XHRQ,
                         TB_EAST_DGDQCKFHZ_REC (I).DQR,
                         TB_EAST_DGDQCKFHZ_REC (I).ZHZT,
                         TB_EAST_DGDQCKFHZ_REC (I).SCDHRQ,
                         TB_EAST_DGDQCKFHZ_REC (I).CHLB,
                         TB_EAST_DGDQCKFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGDQCKFHZMXJL'                    -----对公定期存款分户账明细记录6
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGDQCKFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGDQCKFHZMXJL_REC.COUNT 
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGDQCKFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_DGDQCKFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_DGDQCKFHZMXJL_REC (I).BCXH
                AND DQCKZH = TB_EAST_DGDQCKFHZMXJL_REC (I).DQCKZH
                AND HXJYRQ = TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_DGDQCKFHZMXJL_REC (I).CJRQ; --(HXJYLSH, ZJYLSH, BCXH, DQCKZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGDQCKFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_DGDQCKFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_DGDQCKFHZMXJL_REC (I).BCXH
                   AND TP.DQCKZH = TB_EAST_DGDQCKFHZMXJL_REC (I).DQCKZH
                   AND TP.HXJYRQ = TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_DGDQCKFHZMXJL_REC (I).CJRQ; ---(HXJYLSH, ZJYLSH, BCXH, DQCKZH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGDQCKFHZMXJL_TMP (HXJYLSH,
                                                       ZJYLSH,
                                                       BCXH,
                                                       DQCKZH,
                                                       KHTYBH,
                                                       YXJGDM,
                                                       JRXKZH,
                                                       NBJGH,
                                                       MXKMBH,
                                                       YXJGMC,
                                                       MXKMMC,
                                                       HXJYRQ,
                                                       HXJYSJ,
                                                       BZ,
                                                       ZHMC,
                                                       JYLX,
                                                       JYJE,
                                                       KHHJGH,
                                                       YWBLJGH,
                                                       ZHYE,
                                                       DFZH,
                                                       DFHM,
                                                       DFXH,
                                                       DFXM,
                                                       JYQD,
                                                       XZBZ,
                                                       BFTQZQBZ,
                                                       DBRXM,
                                                       DBRZJLB,
                                                       DBRZJHM,
                                                       JYGYH,
                                                       SQGYH,
                                                       ZY,
                                                       CBMBZ,
                                                       JYJDBZ,
                                                       CJRQ,
                                                       ERRMSG)
                 VALUES (TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).BCXH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DQCKZH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).NBJGH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).BZ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).ZHMC,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JYLX,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JYJE,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).KHHJGH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).YWBLJGH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).ZHYE,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DFZH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DFHM,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DFXH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DFXM,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JYQD,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).XZBZ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).BFTQZQBZ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DBRXM,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JYGYH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).SQGYH,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).ZY,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_DGDQCKFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGHQCKFHZ'                            -----对公活期存款分户账7
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGHQCKFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGHQCKFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGHQCKFHZ_TMP
          WHERE     HQCKZH = TB_EAST_DGHQCKFHZ_REC (I).HQCKZH
                AND BZ = TB_EAST_DGHQCKFHZ_REC (I).BZ
                AND CHLB = TB_EAST_DGHQCKFHZ_REC (I).CHLB
                AND CJRQ = TB_EAST_DGHQCKFHZ_REC (I).CJRQ; --  (HQCKZH, BZ, CHLB, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGHQCKFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HQCKZH = TB_EAST_DGHQCKFHZ_REC (I).HQCKZH
                   AND TP.BZ = TB_EAST_DGHQCKFHZ_REC (I).BZ
                   AND TP.CHLB = TB_EAST_DGHQCKFHZ_REC (I).CHLB
                   AND TP.CJRQ = TB_EAST_DGHQCKFHZ_REC (I).CJRQ; --  (HQCKZH, BZ, CHLB, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGHQCKFHZ_TMP (HQCKZH,
                                                   KHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   YXJGMC,
                                                   MXKMMC,
                                                   TJKMBH,
                                                   BZ,
                                                   ZHMC,
                                                   DGHQCKZHLX,
                                                   BZJZHBZ,
                                                   LL,
                                                   CKYE,
                                                   KHRQ,
                                                   KHGYH,
                                                   XHRQ,
                                                   ZHZT,
                                                   SCDHRQ,
                                                   CHLB,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_DGHQCKFHZ_REC (I).HQCKZH,
                         TB_EAST_DGHQCKFHZ_REC (I).KHTYBH,
                         TB_EAST_DGHQCKFHZ_REC (I).YXJGDM,
                         TB_EAST_DGHQCKFHZ_REC (I).JRXKZH,
                         TB_EAST_DGHQCKFHZ_REC (I).NBJGH,
                         TB_EAST_DGHQCKFHZ_REC (I).MXKMBH,
                         TB_EAST_DGHQCKFHZ_REC (I).YXJGMC,
                         TB_EAST_DGHQCKFHZ_REC (I).MXKMMC,
                         TB_EAST_DGHQCKFHZ_REC (I).TJKMBH,
                         TB_EAST_DGHQCKFHZ_REC (I).BZ,
                         TB_EAST_DGHQCKFHZ_REC (I).ZHMC,
                         TB_EAST_DGHQCKFHZ_REC (I).DGHQCKZHLX,
                         TB_EAST_DGHQCKFHZ_REC (I).BZJZHBZ,
                         TB_EAST_DGHQCKFHZ_REC (I).LL,
                         TB_EAST_DGHQCKFHZ_REC (I).CKYE,
                         TB_EAST_DGHQCKFHZ_REC (I).KHRQ,
                         TB_EAST_DGHQCKFHZ_REC (I).KHGYH,
                         TB_EAST_DGHQCKFHZ_REC (I).XHRQ,
                         TB_EAST_DGHQCKFHZ_REC (I).ZHZT,
                         TB_EAST_DGHQCKFHZ_REC (I).SCDHRQ,
                         TB_EAST_DGHQCKFHZ_REC (I).CHLB,
                         TB_EAST_DGHQCKFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGHQCKFHZMXJL'                    -----对公活期存款分户账明细记录8
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGHQCKFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGHQCKFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGHQCKFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_DGHQCKFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_DGHQCKFHZMXJL_REC (I).BCXH
                AND HQCKZH = TB_EAST_DGHQCKFHZMXJL_REC (I).HQCKZH
                AND HXJYRQ = TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_DGHQCKFHZMXJL_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, HQCKZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGHQCKFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_DGHQCKFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_DGHQCKFHZMXJL_REC (I).BCXH
                   AND TP.HQCKZH = TB_EAST_DGHQCKFHZMXJL_REC (I).HQCKZH
                   AND TP.HXJYRQ = TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_DGHQCKFHZMXJL_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, HQCKZH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGHQCKFHZMXJL_TMP (HXJYLSH,
                                                       ZJYLSH,
                                                       BCXH,
                                                       HQCKZH,
                                                       KHTYBH,
                                                       YXJGDM,
                                                       JRXKZH,
                                                       NBJGH,
                                                       MXKMBH,
                                                       YXJGMC,
                                                       MXKMMC,
                                                       HXJYRQ,
                                                       HXJYSJ,
                                                       ZHMC,
                                                       JYLX,
                                                       JYJE,
                                                       KHHJGH,
                                                       YWBLJGH,
                                                       ZHYE,
                                                       DFZH,
                                                       DFHM,
                                                       DFXH,
                                                       DFXM,
                                                       JYQD,
                                                       BZ,
                                                       XZBZ,
                                                       DBRXM,
                                                       DBRZJLB,
                                                       DBRZJHM,
                                                       JYGYH,
                                                       GYLSH,
                                                       SQGYH,
                                                       ZY,
                                                       CBMBZ,
                                                       JYJDBZ,
                                                       CJRQ,
                                                       ERRMSG)
                 VALUES (TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).BCXH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).HQCKZH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).NBJGH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).ZHMC,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JYLX,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JYJE,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).KHHJGH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).YWBLJGH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).ZHYE,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DFZH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DFHM,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DFXH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DFXM,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JYQD,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).BZ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).XZBZ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DBRXM,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JYGYH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).GYLSH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).SQGYH,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).ZY,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_DGHQCKFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGKH'                                      -----对公客户9
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGKH_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGKH_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGKH_TMP
          WHERE     KHTYBH = TB_EAST_DGKH_REC (I).KHTYBH
                AND CJRQ = TB_EAST_DGKH_REC (I).CJRQ;        -- (KHTYBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGKH_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.KHTYBH = TB_EAST_DGKH_REC (I).KHTYBH
                   AND TP.CJRQ = TB_EAST_DGKH_REC (I).CJRQ;  -- (KHTYBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGKH_TMP (KHTYBH,
                                              ZZJGDM,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              KHMC,
                                              KHYWMC,
                                              FRDB,
                                              FRDBZJLB,
                                              FRDBZJHM,
                                              CWRY,
                                              CWRYZJLB,
                                              CWRYZJHM,
                                              JBCKZH,
                                              JBZHKHXMC,
                                              ZCZB,
                                              ZCDZ,
                                              LXDH,
                                              YYZZH,
                                              YYZZYXJZRQ,
                                              JYFW,
                                              CLRQ,
                                              SSXY,
                                              KHLB,
                                              DKZH,
                                              GSZH,
                                              DSZH,
                                              MGSKHTYBH,
                                              TYSXBZ,
                                              SXED,
                                              YYED,
                                              SSGSBZ,
                                              XYDJBH,
                                              ZCZBBZ,
                                              SSZBBZ,
                                              SSZB,
                                              ZZC,
                                              JZC,
                                              NSR,
                                              SCJLXDGXNY,
                                              YZBM,
                                              CZHM,
                                              YGRS,
                                              XZQHDM,
                                              KHLX,
                                              FXYJXH,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_DGKH_REC (I).KHTYBH,
                         TB_EAST_DGKH_REC (I).ZZJGDM,
                         TB_EAST_DGKH_REC (I).YXJGDM,
                         TB_EAST_DGKH_REC (I).JRXKZH,
                         TB_EAST_DGKH_REC (I).NBJGH,
                         TB_EAST_DGKH_REC (I).KHMC,
                         TB_EAST_DGKH_REC (I).KHYWMC,
                         TB_EAST_DGKH_REC (I).FRDB,
                         TB_EAST_DGKH_REC (I).FRDBZJLB,
                         TB_EAST_DGKH_REC (I).FRDBZJHM,
                         TB_EAST_DGKH_REC (I).CWRY,
                         TB_EAST_DGKH_REC (I).CWRYZJLB,
                         TB_EAST_DGKH_REC (I).CWRYZJHM,
                         TB_EAST_DGKH_REC (I).JBCKZH,
                         TB_EAST_DGKH_REC (I).JBZHKHXMC,
                         TB_EAST_DGKH_REC (I).ZCZB,
                         TB_EAST_DGKH_REC (I).ZCDZ,
                         TB_EAST_DGKH_REC (I).LXDH,
                         TB_EAST_DGKH_REC (I).YYZZH,
                         TB_EAST_DGKH_REC (I).YYZZYXJZRQ,
                         TB_EAST_DGKH_REC (I).JYFW,
                         TB_EAST_DGKH_REC (I).CLRQ,
                         TB_EAST_DGKH_REC (I).SSXY,
                         TB_EAST_DGKH_REC (I).KHLB,
                         TB_EAST_DGKH_REC (I).DKZH,
                         TB_EAST_DGKH_REC (I).GSZH,
                         TB_EAST_DGKH_REC (I).DSZH,
                         TB_EAST_DGKH_REC (I).MGSKHTYBH,
                         TB_EAST_DGKH_REC (I).TYSXBZ,
                         TB_EAST_DGKH_REC (I).SXED,
                         TB_EAST_DGKH_REC (I).YYED,
                         TB_EAST_DGKH_REC (I).SSGSBZ,
                         TB_EAST_DGKH_REC (I).XYDJBH,
                         TB_EAST_DGKH_REC (I).ZCZBBZ,
                         TB_EAST_DGKH_REC (I).SSZBBZ,
                         TB_EAST_DGKH_REC (I).SSZB,
                         TB_EAST_DGKH_REC (I).ZZC,
                         TB_EAST_DGKH_REC (I).JZC,
                         TB_EAST_DGKH_REC (I).NSR,
                         TB_EAST_DGKH_REC (I).SCJLXDGXNY,
                         TB_EAST_DGKH_REC (I).YZBM,
                         TB_EAST_DGKH_REC (I).CZHM,
                         TB_EAST_DGKH_REC (I).YGRS,
                         TB_EAST_DGKH_REC (I).XZQHDM,
                         TB_EAST_DGKH_REC (I).KHLX,
                         TB_EAST_DGKH_REC (I).FXYJXH,
                         TB_EAST_DGKH_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGXDFHZ'                                -----对公信贷分户账10
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGXDFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGXDFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGXDFHZ_TMP
          WHERE     DKFHZH = TB_EAST_DGXDFHZ_REC (I).DKFHZH
                AND XDJJH = TB_EAST_DGXDFHZ_REC (I).XDJJH
                AND BZ = TB_EAST_DGXDFHZ_REC (I).BZ
                AND CJRQ = TB_EAST_DGXDFHZ_REC (I).CJRQ; --  (DKFHZH, XDJJH, BZ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGXDFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DKFHZH = TB_EAST_DGXDFHZ_REC (I).DKFHZH
                   AND TP.XDJJH = TB_EAST_DGXDFHZ_REC (I).XDJJH
                   AND TP.BZ = TB_EAST_DGXDFHZ_REC (I).BZ
                   AND TP.CJRQ = TB_EAST_DGXDFHZ_REC (I).CJRQ; --  (DKFHZH, XDJJH, BZ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGXDFHZ_TMP (DKFHZH,
                                                 XDJJH,
                                                 KHTYBH,
                                                 YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 MXKMBH,
                                                 YXJGMC,
                                                 MXKMMC,
                                                 ZHMC,
                                                 BZ,
                                                 ZJHKRQ,
                                                 TJKMBH,
                                                 DKHTH,
                                                 XDYXM,
                                                 DKWJFL,
                                                 HKZH,
                                                 DKRZZH,
                                                 DKLL,
                                                 DKBJZE,
                                                 DKZCYE,
                                                 DKYQYE,
                                                 QBYE,
                                                 BWQXYE,
                                                 DKQX,
                                                 DQRQ,
                                                 QXRQ,
                                                 KHRQ,
                                                 XHRQ,
                                                 YQRQ,
                                                 ZHZT,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_DGXDFHZ_REC (I).DKFHZH,
                         TB_EAST_DGXDFHZ_REC (I).XDJJH,
                         TB_EAST_DGXDFHZ_REC (I).KHTYBH,
                         TB_EAST_DGXDFHZ_REC (I).YXJGDM,
                         TB_EAST_DGXDFHZ_REC (I).JRXKZH,
                         TB_EAST_DGXDFHZ_REC (I).NBJGH,
                         TB_EAST_DGXDFHZ_REC (I).MXKMBH,
                         TB_EAST_DGXDFHZ_REC (I).YXJGMC,
                         TB_EAST_DGXDFHZ_REC (I).MXKMMC,
                         TB_EAST_DGXDFHZ_REC (I).ZHMC,
                         TB_EAST_DGXDFHZ_REC (I).BZ,
                         TB_EAST_DGXDFHZ_REC (I).TJKMBH,
                         TB_EAST_DGXDFHZ_REC (I).ZJHKRQ,
                         TB_EAST_DGXDFHZ_REC (I).DKHTH,
                         TB_EAST_DGXDFHZ_REC (I).XDYXM,
                         TB_EAST_DGXDFHZ_REC (I).DKWJFL,
                         TB_EAST_DGXDFHZ_REC (I).HKZH,
                         TB_EAST_DGXDFHZ_REC (I).DKRZZH,
                         TB_EAST_DGXDFHZ_REC (I).DKLL,
                         TB_EAST_DGXDFHZ_REC (I).DKBJZE,
                         TB_EAST_DGXDFHZ_REC (I).DKZCYE,
                         TB_EAST_DGXDFHZ_REC (I).DKYQYE,
                         TB_EAST_DGXDFHZ_REC (I).QBYE,
                         TB_EAST_DGXDFHZ_REC (I).BWQXYE,
                         TB_EAST_DGXDFHZ_REC (I).DKQX,
                         TB_EAST_DGXDFHZ_REC (I).DQRQ,
                         TB_EAST_DGXDFHZ_REC (I).QXRQ,
                         TB_EAST_DGXDFHZ_REC (I).KHRQ,
                         TB_EAST_DGXDFHZ_REC (I).XHRQ,
                         TB_EAST_DGXDFHZ_REC (I).YQRQ,
                         TB_EAST_DGXDFHZ_REC (I).ZHZT,
                         TB_EAST_DGXDFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGXDFHZMXJL'                        -----对公信贷分户账明细记录11
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGXDFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGXDFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGXDFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_DGXDFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_DGXDFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_DGXDFHZMXJL_REC (I).BCXH
                AND DKZH = TB_EAST_DGXDFHZMXJL_REC (I).DKZH
                AND HXJYRQ = TB_EAST_DGXDFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_DGXDFHZMXJL_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, DKZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGXDFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_DGXDFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_DGXDFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_DGXDFHZMXJL_REC (I).BCXH
                   AND TP.DKZH = TB_EAST_DGXDFHZMXJL_REC (I).DKZH
                   AND TP.HXJYRQ = TB_EAST_DGXDFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_DGXDFHZMXJL_REC (I).CJRQ;
         ELSE
            INSERT INTO REPORT.EAST_DGXDFHZMXJL_TMP (HXJYLSH,
                                                     ZJYLSH,
                                                     BCXH,
                                                     DKZH,
                                                     KHTYBH,
                                                     YXJGDM,
                                                     JRXKZH,
                                                     NBJGH,
                                                     MXKMBH,
                                                     XDJJH,
                                                     YXJGMC,
                                                     MXKMMC,
                                                     HXJYRQ,
                                                     HXJYSJ,
                                                     ZHMC,
                                                     JYLX,
                                                     JYJDBZ,
                                                     JYJE,
                                                     ZHYE,
                                                     DFZH,
                                                     DFHM,
                                                     DFXH,
                                                     DFXM,
                                                     JYQD,
                                                     BZ,
                                                     ZY,
                                                     CBMBZ,
                                                     DBRXM,
                                                     DBRZJLB,
                                                     DBRZJHM,
                                                     JYGYH,
                                                     SQGYH,
                                                     XZBZ,
                                                     CJRQ,
                                                     ERRMSG)
                 VALUES (TB_EAST_DGXDFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_DGXDFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_DGXDFHZMXJL_REC (I).BCXH,
                         TB_EAST_DGXDFHZMXJL_REC (I).DKZH,
                         TB_EAST_DGXDFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_DGXDFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_DGXDFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_DGXDFHZMXJL_REC (I).NBJGH,
                         TB_EAST_DGXDFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_DGXDFHZMXJL_REC (I).XDJJH,
                         TB_EAST_DGXDFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_DGXDFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_DGXDFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_DGXDFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_DGXDFHZMXJL_REC (I).ZHMC,
                         TB_EAST_DGXDFHZMXJL_REC (I).JYLX,
                         TB_EAST_DGXDFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_DGXDFHZMXJL_REC (I).JYJE,
                         TB_EAST_DGXDFHZMXJL_REC (I).ZHYE,
                         TB_EAST_DGXDFHZMXJL_REC (I).DFZH,
                         TB_EAST_DGXDFHZMXJL_REC (I).DFHM,
                         TB_EAST_DGXDFHZMXJL_REC (I).DFXH,
                         TB_EAST_DGXDFHZMXJL_REC (I).DFXM,
                         TB_EAST_DGXDFHZMXJL_REC (I).JYQD,
                         TB_EAST_DGXDFHZMXJL_REC (I).BZ,
                         TB_EAST_DGXDFHZMXJL_REC (I).ZY,
                         TB_EAST_DGXDFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_DGXDFHZMXJL_REC (I).DBRXM,
                         TB_EAST_DGXDFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_DGXDFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_DGXDFHZMXJL_REC (I).JYGYH,
                         TB_EAST_DGXDFHZMXJL_REC (I).SQGYH,
                         TB_EAST_DGXDFHZMXJL_REC (I).XZBZ,
                         TB_EAST_DGXDFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DGXDYWJJ'                              -----对公信贷业务借据12
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DGXDYWJJ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DGXDYWJJ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DGXDYWJJ_TMP
          WHERE     XDJJH = TB_EAST_DGXDYWJJ_REC (I).XDJJH
                AND CJRQ = TB_EAST_DGXDYWJJ_REC (I).CJRQ;      --(XDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DGXDYWJJ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.XDJJH = TB_EAST_DGXDYWJJ_REC (I).XDJJH
                   AND TP.CJRQ = TB_EAST_DGXDYWJJ_REC (I).CJRQ; --(XDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DGXDYWJJ_TMP (XDJJH,
                                                  DKFHZH,
                                                  KHTYBH,
                                                  KHMC,
                                                  XDHTH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  MXKMBH,
                                                  YXJGMC,
                                                  MXKMMC,
                                                  XDYWZL,
                                                  BZ,
                                                  JKJE,
                                                  JKYE,
                                                  DKQX,
                                                  ZQCS,
                                                  ZQS,
                                                  DQQS,
                                                  FKFS,
                                                  DKSJFFRQ,
                                                  DKYSDQRQ,
                                                  DKSJDQRQ,
                                                  BNQXYE,
                                                  BWQXYE,
                                                  DKZT,
                                                  ZJRQ,
                                                  DKLX,
                                                  DKRZZH,
                                                  DKWJFL,
                                                  LLLX,
                                                  JZLL,
                                                  LLFD,
                                                  HKFS,
                                                  HKZH,
                                                  HKQD,
                                                  JXFS,
                                                  BZJBL,
                                                  BZJBZ,
                                                  BZJJE,
                                                  BZJZH,
                                                  PJHM,
                                                  PMJE,
                                                  XDYXM,
                                                  XDYGH,
                                                  XZBZ,
                                                  LJQKQS,
                                                  LXQKQS,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_DGXDYWJJ_REC (I).XDJJH,
                         TB_EAST_DGXDYWJJ_REC (I).DKFHZH,
                         TB_EAST_DGXDYWJJ_REC (I).KHTYBH,
                         TB_EAST_DGXDYWJJ_REC (I).KHMC,
                         TB_EAST_DGXDYWJJ_REC (I).XDHTH,
                         TB_EAST_DGXDYWJJ_REC (I).YXJGDM,
                         TB_EAST_DGXDYWJJ_REC (I).JRXKZH,
                         TB_EAST_DGXDYWJJ_REC (I).NBJGH,
                         TB_EAST_DGXDYWJJ_REC (I).MXKMBH,
                         TB_EAST_DGXDYWJJ_REC (I).YXJGMC,
                         TB_EAST_DGXDYWJJ_REC (I).MXKMMC,
                         TB_EAST_DGXDYWJJ_REC (I).XDYWZL,
                         TB_EAST_DGXDYWJJ_REC (I).BZ,
                         TB_EAST_DGXDYWJJ_REC (I).JKJE,
                         TB_EAST_DGXDYWJJ_REC (I).JKYE,
                         TB_EAST_DGXDYWJJ_REC (I).DKQX,
                         TB_EAST_DGXDYWJJ_REC (I).ZQCS,
                         TB_EAST_DGXDYWJJ_REC (I).ZQS,
                         TB_EAST_DGXDYWJJ_REC (I).DQQS,
                         TB_EAST_DGXDYWJJ_REC (I).FKFS,
                         TB_EAST_DGXDYWJJ_REC (I).DKSJFFRQ,
                         TB_EAST_DGXDYWJJ_REC (I).DKYSDQRQ,
                         TB_EAST_DGXDYWJJ_REC (I).DKSJDQRQ,
                         TB_EAST_DGXDYWJJ_REC (I).BNQXYE,
                         TB_EAST_DGXDYWJJ_REC (I).BWQXYE,
                         TB_EAST_DGXDYWJJ_REC (I).DKZT,
                         TB_EAST_DGXDYWJJ_REC (I).ZJRQ,
                         TB_EAST_DGXDYWJJ_REC (I).DKLX,
                         TB_EAST_DGXDYWJJ_REC (I).DKRZZH,
                         TB_EAST_DGXDYWJJ_REC (I).DKWJFL,
                         TB_EAST_DGXDYWJJ_REC (I).LLLX,
                         TB_EAST_DGXDYWJJ_REC (I).JZLL,
                         TB_EAST_DGXDYWJJ_REC (I).LLFD,
                         TB_EAST_DGXDYWJJ_REC (I).HKFS,
                         TB_EAST_DGXDYWJJ_REC (I).HKZH,
                         TB_EAST_DGXDYWJJ_REC (I).HKQD,
                         TB_EAST_DGXDYWJJ_REC (I).JXFS,
                         TB_EAST_DGXDYWJJ_REC (I).BZJBL,
                         TB_EAST_DGXDYWJJ_REC (I).BZJBZ,
                         TB_EAST_DGXDYWJJ_REC (I).BZJJE,
                         TB_EAST_DGXDYWJJ_REC (I).BZJZH,
                         TB_EAST_DGXDYWJJ_REC (I).PJHM,
                         TB_EAST_DGXDYWJJ_REC (I).PMJE,
                         TB_EAST_DGXDYWJJ_REC (I).XDYXM,
                         TB_EAST_DGXDYWJJ_REC (I).XDYGH,
                         TB_EAST_DGXDYWJJ_REC (I).XZBZ,
                         TB_EAST_DGXDYWJJ_REC (I).LJQKQS,
                         TB_EAST_DGXDYWJJ_REC (I).LXQKQS,
                         TB_EAST_DGXDYWJJ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DKHX'                             --EAST_DKHX---贷款核销13
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DKHX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DKHX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DKHX_TMP
          WHERE     XDJJH = TB_EAST_DKHX_REC (I).XDJJH
                AND HXRQ = TB_EAST_DKHX_REC (I).HXRQ
                AND HXSHRQ = TB_EAST_DKHX_REC (I).HXSHRQ
                AND CJRQ = TB_EAST_DKHX_REC (I).CJRQ; --(XDJJH, HXRQ, HXSHRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DKHX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.XDJJH = TB_EAST_DKHX_REC (I).XDJJH
                   AND TP.HXRQ = TB_EAST_DKHX_REC (I).HXRQ
                   AND TP.HXSHRQ = TB_EAST_DKHX_REC (I).HXSHRQ
                   AND TP.CJRQ = TB_EAST_DKHX_REC (I).CJRQ; --(XDJJH, HXRQ, HXSHRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DKHX_TMP (XDJJH,
                                              XDHTH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              MXKMBH,
                                              MXKMMC,
                                              KMGSJG,
                                              BZ,
                                              SHDKBJ,
                                              SHBNLX,
                                              SHBWLX,
                                              HXRQ,
                                              HXSHBJ,
                                              HXSHBNLX,
                                              HXSHBWLX,
                                              SHBZ,
                                              HXSHGYH,
                                              HXSHRQ,
                                              BZH,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_DKHX_REC (I).XDJJH,
                         TB_EAST_DKHX_REC (I).XDHTH,
                         TB_EAST_DKHX_REC (I).KHTYBH,
                         TB_EAST_DKHX_REC (I).YXJGDM,
                         TB_EAST_DKHX_REC (I).JRXKZH,
                         TB_EAST_DKHX_REC (I).NBJGH,
                         TB_EAST_DKHX_REC (I).MXKMBH,
                         TB_EAST_DKHX_REC (I).MXKMMC,
                         TB_EAST_DKHX_REC (I).KMGSJG,
                         TB_EAST_DKHX_REC (I).BZ,
                         TB_EAST_DKHX_REC (I).SHDKBJ,
                         TB_EAST_DKHX_REC (I).SHBNLX,
                         TB_EAST_DKHX_REC (I).SHBWLX,
                         TB_EAST_DKHX_REC (I).HXRQ,
                         TB_EAST_DKHX_REC (I).HXSHBJ,
                         TB_EAST_DKHX_REC (I).HXSHBNLX,
                         TB_EAST_DKHX_REC (I).HXSHBWLX,
                         TB_EAST_DKHX_REC (I).SHBZ,
                         TB_EAST_DKHX_REC (I).HXSHGYH,
                         TB_EAST_DKHX_REC (I).HXSHRQ,
                         TB_EAST_DKHX_REC (I).BZH,
                         TB_EAST_DKHX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DKWJXTBD'                 --EAST_DKWJXTBD---贷款五级形态变动14
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DKWJXTBD_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DKWJXTBD_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DKWJXTBD_TMP
          WHERE     TZRQ = TB_EAST_DKWJXTBD_REC (I).TZRQ
                AND XDJJH = TB_EAST_DKWJXTBD_REC (I).XDJJH
                AND CJRQ = TB_EAST_DKWJXTBD_REC (I).CJRQ; --  (TZRQ, XDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DKWJXTBD_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.TZRQ = TB_EAST_DKWJXTBD_REC (I).TZRQ
                   AND TP.XDJJH = TB_EAST_DKWJXTBD_REC (I).XDJJH
                   AND TP.CJRQ = TB_EAST_DKWJXTBD_REC (I).CJRQ; --  (TZRQ, XDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DKWJXTBD_TMP (TZRQ,
                                                  XDJJH,
                                                  XDHTH,
                                                  KHTYBH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  YXJGMC,
                                                  YMXKMBH,
                                                  YMXKMMC,
                                                  YWJXT,
                                                  XMXKMBH,
                                                  XMXKMMC,
                                                  XWJXT,
                                                  BZ,
                                                  ZRJE,
                                                  ZCJE,
                                                  KHMC,
                                                  JBGYH,
                                                  TZGYH,
                                                  SQGYH,
                                                  SPGYH,
                                                  BDYY,
                                                  BDFS,
                                                  ERRMSG,
                                                  CJRQ)
                 VALUES (TB_EAST_DKWJXTBD_REC (I).TZRQ,
                         TB_EAST_DKWJXTBD_REC (I).XDJJH,
                         TB_EAST_DKWJXTBD_REC (I).XDHTH,
                         TB_EAST_DKWJXTBD_REC (I).KHTYBH,
                         TB_EAST_DKWJXTBD_REC (I).YXJGDM,
                         TB_EAST_DKWJXTBD_REC (I).JRXKZH,
                         TB_EAST_DKWJXTBD_REC (I).NBJGH,
                         TB_EAST_DKWJXTBD_REC (I).YXJGMC,
                         TB_EAST_DKWJXTBD_REC (I).YMXKMBH,
                         TB_EAST_DKWJXTBD_REC (I).YMXKMMC,
                         TB_EAST_DKWJXTBD_REC (I).YWJXT,
                         TB_EAST_DKWJXTBD_REC (I).XMXKMBH,
                         TB_EAST_DKWJXTBD_REC (I).XMXKMMC,
                         TB_EAST_DKWJXTBD_REC (I).XWJXT,
                         TB_EAST_DKWJXTBD_REC (I).BZ,
                         TB_EAST_DKWJXTBD_REC (I).ZRJE,
                         TB_EAST_DKWJXTBD_REC (I).ZCJE,
                         TB_EAST_DKWJXTBD_REC (I).KHMC,
                         TB_EAST_DKWJXTBD_REC (I).JBGYH,
                         TB_EAST_DKWJXTBD_REC (I).TZGYH,
                         TB_EAST_DKWJXTBD_REC (I).SQGYH,
                         TB_EAST_DKWJXTBD_REC (I).SPGYH,
                         TB_EAST_DKWJXTBD_REC (I).BDYY,
                         TB_EAST_DKWJXTBD_REC (I).BDFS,
                         P_ERRMSG,
                         TB_EAST_DKWJXTBD_REC (I).CJRQ);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_DKZQ'                                      -----贷款展期15
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_DKZQ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_DKZQ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_DKZQ_TMP
          WHERE     DKZQBH = TB_EAST_DKZQ_REC (I).DKZQBH
                AND CJRQ = TB_EAST_DKZQ_REC (I).CJRQ;       --  (DKZQBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_DKZQ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DKZQBH = TB_EAST_DKZQ_REC (I).DKZQBH
                   AND TP.CJRQ = TB_EAST_DKZQ_REC (I).CJRQ; --  (DKZQBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_DKZQ_TMP (DKZQBH,
                                              XDJJH,
                                              XDHTH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              ZQRQ,
                                              ZQDQRQ,
                                              ZQJE,
                                              YLL,
                                              LLLX,
                                              ZQJZLL,
                                              LLFD,
                                              YHTH,
                                              YJJH,
                                              JYGYH,
                                              SQGYH,
                                              ERRMSG,
                                              CJRQ)
                 VALUES (TB_EAST_DKZQ_REC (I).DKZQBH,
                         TB_EAST_DKZQ_REC (I).XDJJH,
                         TB_EAST_DKZQ_REC (I).XDHTH,
                         TB_EAST_DKZQ_REC (I).KHTYBH,
                         TB_EAST_DKZQ_REC (I).YXJGDM,
                         TB_EAST_DKZQ_REC (I).JRXKZH,
                         TB_EAST_DKZQ_REC (I).NBJGH,
                         TB_EAST_DKZQ_REC (I).ZQRQ,
                         TB_EAST_DKZQ_REC (I).ZQDQRQ,
                         TB_EAST_DKZQ_REC (I).ZQJE,
                         TB_EAST_DKZQ_REC (I).YLL,
                         TB_EAST_DKZQ_REC (I).LLLX,
                         TB_EAST_DKZQ_REC (I).ZQJZLL,
                         TB_EAST_DKZQ_REC (I).LLFD,
                         TB_EAST_DKZQ_REC (I).YHTH,
                         TB_EAST_DKZQ_REC (I).YJJH,
                         TB_EAST_DKZQ_REC (I).JYGYH,
                         TB_EAST_DKZQ_REC (I).SQGYH,
                         P_ERRMSG,
                         TB_EAST_DKZQ_REC (I).CJRQ);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_GDXX'                                      -----股东信息16
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GDXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GDXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GDXX_TMP
          WHERE     KHTYBH = TB_EAST_GDXX_REC (I).KHTYBH
                AND GDZJHM = TB_EAST_GDXX_REC (I).GDZJHM
                AND CJRQ = TB_EAST_GDXX_REC (I).CJRQ; -- (KHTYBH, GDZJHM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GDXX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.KHTYBH = TB_EAST_GDXX_REC (I).KHTYBH
                   AND TP.GDZJHM = TB_EAST_GDXX_REC (I).GDZJHM
                   AND TP.CJRQ = TB_EAST_GDXX_REC (I).CJRQ; -- (KHTYBH, GDZJHM, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GDXX_TMP (KHTYBH,
                                              ZZJGDM,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              GDMC,
                                              GDZJLB,
                                              GDZJHM,
                                              GDZT,
                                              CGBL,
                                              RGSJ,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_GDXX_REC (I).KHTYBH,
                         TB_EAST_GDXX_REC (I).ZZJGDM,
                         TB_EAST_GDXX_REC (I).YXJGDM,
                         TB_EAST_GDXX_REC (I).JRXKZH,
                         TB_EAST_GDXX_REC (I).NBJGH,
                         TB_EAST_GDXX_REC (I).GDMC,
                         TB_EAST_GDXX_REC (I).GDZJLB,
                         TB_EAST_GDXX_REC (I).GDZJHM,
                         TB_EAST_GDXX_REC (I).GDZT,
                         TB_EAST_GDXX_REC (I).CGBL,
                         TB_EAST_GDXX_REC (I).RGSJ,
                         TB_EAST_GDXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ELSIF P_TBNAME = 'EAST_GLGX'                                      -----关联关系17
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GLGX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GLGX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GLGX_TMP
          WHERE     KHTYBH = TB_EAST_GLGX_REC (I).KHTYBH
                AND GLRKHTYBH = TB_EAST_GLGX_REC (I).GLRKHTYBH
                AND CJRQ = TB_EAST_GLGX_REC (I).CJRQ; --(KHTYBH, GLRKHTYBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GLGX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.KHTYBH = TB_EAST_GLGX_REC (I).KHTYBH
                   AND GLRKHTYBH = TB_EAST_GLGX_REC (I).GLRKHTYBH
                   AND CJRQ = TB_EAST_GLGX_REC (I).CJRQ; --(KHTYBH, GLRKHTYBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GLGX_TMP (KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              GLRKHTYBH,
                                              KHSBM,
                                              KHLB,
                                              GLRSBM,
                                              GLRMC,
                                              GLRLB,
                                              GXLX,
                                              GLGXZT,
                                              LRSJ,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_GLGX_REC (I).KHTYBH,
                         TB_EAST_GLGX_REC (I).YXJGDM,
                         TB_EAST_GLGX_REC (I).JRXKZH,
                         TB_EAST_GLGX_REC (I).NBJGH,
                         TB_EAST_GLGX_REC (I).GLRKHTYBH,
                         TB_EAST_GLGX_REC (I).KHSBM,
                         TB_EAST_GLGX_REC (I).KHLB,
                         TB_EAST_GLGX_REC (I).GLRSBM,
                         TB_EAST_GLGX_REC (I).GLRMC,
                         TB_EAST_GLGX_REC (I).GLRLB,
                         TB_EAST_GLGX_REC (I).GXLX,
                         TB_EAST_GLGX_REC (I).GLGXZT,
                         TB_EAST_GLGX_REC (I).LRSJ,
                         TB_EAST_GLGX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ------------------------------
   ELSIF P_TBNAME = 'EAST_GRDQCKFHZ'                            -----个人定期存款分户账18
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRDQCKFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRDQCKFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRDQCKFHZ_TMP
          WHERE     DQCKZH = TB_EAST_GRDQCKFHZ_REC (I).DQCKZH
                AND BZ = TB_EAST_GRDQCKFHZ_REC (I).BZ
                AND JYJZH = TB_EAST_GRDQCKFHZ_REC (I).JYJZH
                AND CHLB = TB_EAST_GRDQCKFHZ_REC (I).CHLB
                AND CJRQ = TB_EAST_GRDQCKFHZ_REC (I).CJRQ; --(DQCKZH, BZ, JYJZH, CHLB, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRDQCKFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DQCKZH = TB_EAST_GRDQCKFHZ_REC (I).DQCKZH
                   AND TP.BZ = TB_EAST_GRDQCKFHZ_REC (I).BZ
                   AND TP.JYJZH = TB_EAST_GRDQCKFHZ_REC (I).JYJZH
                   AND TP.CHLB = TB_EAST_GRDQCKFHZ_REC (I).CHLB
                   AND TP.CJRQ = TB_EAST_GRDQCKFHZ_REC (I).CJRQ; --(DQCKZH, BZ, JYJZH, CHLB, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRDQCKFHZ_TMP (DQCKZH,
                                                   GRKHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   MXKMMC,
                                                   YXJGMC,
                                                   BZ,
                                                   TJKMBH,
                                                   ZHMC,
                                                   GRDQCKZHLX,
                                                   CKQX,
                                                   LL,
                                                   JYJZMC,
                                                   JYJZH,
                                                   BZJZHBZ,
                                                   KHJE,
                                                   CKYE,
                                                   KHRQ,
                                                   KHGYH,
                                                   XHRQ,
                                                   DQR,
                                                   ZHZT,
                                                   SCDHRQ,
                                                   CHLB,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_GRDQCKFHZ_REC (I).DQCKZH,
                         TB_EAST_GRDQCKFHZ_REC (I).GRKHTYBH,
                         TB_EAST_GRDQCKFHZ_REC (I).YXJGDM,
                         TB_EAST_GRDQCKFHZ_REC (I).JRXKZH,
                         TB_EAST_GRDQCKFHZ_REC (I).NBJGH,
                         TB_EAST_GRDQCKFHZ_REC (I).MXKMBH,
                         TB_EAST_GRDQCKFHZ_REC (I).MXKMMC,
                         TB_EAST_GRDQCKFHZ_REC (I).YXJGMC,
                         TB_EAST_GRDQCKFHZ_REC (I).BZ,
                         TB_EAST_GRDQCKFHZ_REC (I).TJKMBH,
                         TB_EAST_GRDQCKFHZ_REC (I).ZHMC,
                         TB_EAST_GRDQCKFHZ_REC (I).GRDQCKZHLX,
                         TB_EAST_GRDQCKFHZ_REC (I).CKQX,
                         TB_EAST_GRDQCKFHZ_REC (I).LL,
                         TB_EAST_GRDQCKFHZ_REC (I).JYJZMC,
                         TB_EAST_GRDQCKFHZ_REC (I).JYJZH,
                         TB_EAST_GRDQCKFHZ_REC (I).BZJZHBZ,
                         TB_EAST_GRDQCKFHZ_REC (I).KHJE,
                         TB_EAST_GRDQCKFHZ_REC (I).CKYE,
                         TB_EAST_GRDQCKFHZ_REC (I).KHRQ,
                         TB_EAST_GRDQCKFHZ_REC (I).KHGYH,
                         TB_EAST_GRDQCKFHZ_REC (I).XHRQ,
                         TB_EAST_GRDQCKFHZ_REC (I).DQR,
                         TB_EAST_GRDQCKFHZ_REC (I).ZHZT,
                         TB_EAST_GRDQCKFHZ_REC (I).SCDHRQ,
                         TB_EAST_GRDQCKFHZ_REC (I).CHLB,
                         TB_EAST_GRDQCKFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -------------------------------------------
   ELSIF P_TBNAME = 'EAST_GRDQCKFHZMXJLMXJL'                -----个人定期存款分户账明细记录19
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRDQCKFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRDQCKFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRDQCKFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_GRDQCKFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_GRDQCKFHZMXJL_REC (I).BCXH
                AND DQCKZH = TB_EAST_GRDQCKFHZMXJL_REC (I).DQCKZH
                AND HXJYRQ = TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_GRDQCKFHZMXJL_REC (I).CJRQ; --  (HXJYLSH, ZJYLSH, BCXH, DQCKZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRDQCKFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_GRDQCKFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_GRDQCKFHZMXJL_REC (I).BCXH
                   AND TP.DQCKZH = TB_EAST_GRDQCKFHZMXJL_REC (I).DQCKZH
                   AND TP.HXJYRQ = TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_GRDQCKFHZMXJL_REC (I).CJRQ; --  (HXJYLSH, ZJYLSH, BCXH, DQCKZH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRDQCKFHZMXJL_TMP (HXJYLSH,
                                                       ZJYLSH,
                                                       BCXH,
                                                       DQCKZH,
                                                       KHTYBH,
                                                       YXJGDM,
                                                       JRXKZH,
                                                       NBJGH,
                                                       MXKMBH,
                                                       YXJGMC,
                                                       MXKMMC,
                                                       HXJYRQ,
                                                       HXJYSJ,
                                                       BZ,
                                                       ZHMC,
                                                       JYLX,
                                                       JYJE,
                                                       KHHJGH,
                                                       YWBLJGH,
                                                       ZHYE,
                                                       DFZH,
                                                       DFHM,
                                                       DFXH,
                                                       DFXM,
                                                       JYQD,
                                                       XZBZ,
                                                       BFTQZQBZ,
                                                       DBRXM,
                                                       DBRZJLB,
                                                       DBRZJHM,
                                                       JYGYH,
                                                       SQGYH,
                                                       ZY,
                                                       CBMBZ,
                                                       JYJDBZ,
                                                       CJRQ,
                                                       ERRMSG)
                 VALUES (TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).BCXH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DQCKZH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).NBJGH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).BZ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).ZHMC,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JYLX,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JYJE,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).KHHJGH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).YWBLJGH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).ZHYE,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DFZH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DFHM,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DFXH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DFXM,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JYQD,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).XZBZ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).BFTQZQBZ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DBRXM,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JYGYH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).SQGYH,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).ZY,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_GRDQCKFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------EAST_GRHQCKFHZ-----个人活期存款分户账--20---------------------------
   ELSIF P_TBNAME = 'EAST_GRHQCKFHZ'                            -----个人活期存款分户账
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRHQCKFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRHQCKFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRHQCKFHZ_TMP
          WHERE     HQCKZH = TB_EAST_GRHQCKFHZ_REC (I).HQCKZH
                AND BZ = TB_EAST_GRHQCKFHZ_REC (I).BZ
                AND JYJZH = TB_EAST_GRHQCKFHZ_REC (I).JYJZH
                AND CHLB = TB_EAST_GRHQCKFHZ_REC (I).CHLB
                AND CJRQ = TB_EAST_GRHQCKFHZ_REC (I).CJRQ; --   (HQCKZH, BZ, JYJZH, CHLB, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRHQCKFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HQCKZH = TB_EAST_GRHQCKFHZ_REC (I).HQCKZH
                   AND TP.BZ = TB_EAST_GRHQCKFHZ_REC (I).BZ
                   AND TP.JYJZH = TB_EAST_GRHQCKFHZ_REC (I).JYJZH
                   AND TP.CHLB = TB_EAST_GRHQCKFHZ_REC (I).CHLB
                   AND TP.CJRQ = TB_EAST_GRHQCKFHZ_REC (I).CJRQ; --   (HQCKZH, BZ, JYJZH, CHLB, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRHQCKFHZ_TMP (HQCKZH,
                                                   KHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   YXJGMC,
                                                   MXKMMC,
                                                   TJKMBH,
                                                   BZ,
                                                   ZHMC,
                                                   GRHQCKZHLX,
                                                   JYJZMC,
                                                   JYJZH,
                                                   BZJZHBZ,
                                                   LL,
                                                   CKYE,
                                                   KHRQ,
                                                   KHGYH,
                                                   XHRQ,
                                                   ZHZT,
                                                   SCDHRQ,
                                                   CHLB,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_GRHQCKFHZ_REC (I).HQCKZH,
                         TB_EAST_GRHQCKFHZ_REC (I).KHTYBH,
                         TB_EAST_GRHQCKFHZ_REC (I).YXJGDM,
                         TB_EAST_GRHQCKFHZ_REC (I).JRXKZH,
                         TB_EAST_GRHQCKFHZ_REC (I).NBJGH,
                         TB_EAST_GRHQCKFHZ_REC (I).MXKMBH,
                         TB_EAST_GRHQCKFHZ_REC (I).YXJGMC,
                         TB_EAST_GRHQCKFHZ_REC (I).MXKMMC,
                         TB_EAST_GRHQCKFHZ_REC (I).TJKMBH,
                         TB_EAST_GRHQCKFHZ_REC (I).BZ,
                         TB_EAST_GRHQCKFHZ_REC (I).ZHMC,
                         TB_EAST_GRHQCKFHZ_REC (I).GRHQCKZHLX,
                         TB_EAST_GRHQCKFHZ_REC (I).JYJZMC,
                         TB_EAST_GRHQCKFHZ_REC (I).JYJZH,
                         TB_EAST_GRHQCKFHZ_REC (I).BZJZHBZ,
                         TB_EAST_GRHQCKFHZ_REC (I).LL,
                         TB_EAST_GRHQCKFHZ_REC (I).CKYE,
                         TB_EAST_GRHQCKFHZ_REC (I).KHRQ,
                         TB_EAST_GRHQCKFHZ_REC (I).KHGYH,
                         TB_EAST_GRHQCKFHZ_REC (I).XHRQ,
                         TB_EAST_GRHQCKFHZ_REC (I).ZHZT,
                         TB_EAST_GRHQCKFHZ_REC (I).SCDHRQ,
                         TB_EAST_GRHQCKFHZ_REC (I).CHLB,
                         TB_EAST_GRHQCKFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -------------EAST_GRHQCKFHZ---个人活期存款分户账----------------
   ------------------EAST_GRHQCKFHZMXJLMXJL---个人活期存款分户账明细记录-----START-----21-------------------
   ELSIF P_TBNAME = 'EAST_GRHQCKFHZMXJL'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRHQCKFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRHQCKFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRHQCKFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_GRHQCKFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_GRHQCKFHZMXJL_REC (I).BCXH
                AND HQCKZH = TB_EAST_GRHQCKFHZMXJL_REC (I).HQCKZH
                AND HXJYRQ = TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_GRHQCKFHZMXJL_REC (I).CJRQ; --   (HXJYLSH, ZJYLSH, BCXH, HQCKZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRHQCKFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_GRHQCKFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_GRHQCKFHZMXJL_REC (I).BCXH
                   AND TP.HQCKZH = TB_EAST_GRHQCKFHZMXJL_REC (I).HQCKZH
                   AND TP.HXJYRQ = TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_GRHQCKFHZMXJL_REC (I).CJRQ; --   (HXJYLSH, ZJYLSH, BCXH, HQCKZH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRHQCKFHZMXJL_TMP (HXJYLSH,
                                                       ZJYLSH,
                                                       BCXH,
                                                       HQCKZH,
                                                       KHTYBH,
                                                       YXJGDM,
                                                       JRXKZH,
                                                       NBJGH,
                                                       MXKMBH,
                                                       YXJGMC,
                                                       MXKMMC,
                                                       HXJYRQ,
                                                       HXJYSJ,
                                                       BZ,
                                                       ZHMC,
                                                       JYLX,
                                                       JYJE,
                                                       KHHJGH,
                                                       YWBLJGH,
                                                       ZHYE,
                                                       DFZH,
                                                       DFHM,
                                                       DFXH,
                                                       DFXM,
                                                       JYQD,
                                                       XZBZ,
                                                       DBRXM,
                                                       DBRZJLB,
                                                       DBRZJHM,
                                                       JYGYH,
                                                       GYLSH,
                                                       SQGYH,
                                                       ZY,
                                                       CBMBZ,
                                                       JYJDBZ,
                                                       CJRQ,
                                                       ERRMSG)
                 VALUES (TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).BCXH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).HQCKZH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).NBJGH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).BZ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).ZHMC,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JYLX,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JYJE,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).KHHJGH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).YWBLJGH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).ZHYE,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DFZH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DFHM,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DFXH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DFXM,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JYQD,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).XZBZ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DBRXM,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JYGYH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).GYLSH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).SQGYH,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).ZY,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_GRHQCKFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_GRHQCKFHZMXJLMXJL---个人活期存款分户账明细记录--END--------------

   -------------------EAST_GRJCXX---个人基础信息-----START----22--------------------
   ELSIF P_TBNAME = 'EAST_GRJCXX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRJCXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRJCXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRJCXX_TMP
          WHERE     KHTYBH = TB_EAST_GRJCXX_REC (I).KHTYBH
                AND CJRQ = TB_EAST_GRJCXX_REC (I).CJRQ;    --   (KHTYBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRJCXX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.KHTYBH = TB_EAST_GRJCXX_REC (I).KHTYBH
                   AND CJRQ = TB_EAST_GRJCXX_REC (I).CJRQ; --   (KHTYBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRJCXX_TMP (KHTYBH,
                                                ZJHM,
                                                YXJGDM,
                                                JRXKZH,
                                                NBJGH,
                                                LYXT,
                                                KHXM,
                                                KHYWXM,
                                                ZJLB,
                                                GJ,
                                                MZ,
                                                XB,
                                                XL,
                                                CSRQ,
                                                GZDWMC,
                                                GZDWDZ,
                                                GZDWDH,
                                                ZY,
                                                JTZZ,
                                                TXDZ,
                                                JTDH,
                                                YDDH,
                                                GRYSR,
                                                JTYSR,
                                                HYQK,
                                                POXM,
                                                POLXDH,
                                                POYDDH,
                                                PODYKHH,
                                                BXYGBZ,
                                                SBXHMDBZ,
                                                SHMDRQ,
                                                SHMDYY,
                                                YZBM,
                                                DWXZ,
                                                ZC,
                                                SFNH,
                                                CJRQ,
                                                ERRMSG)
                 VALUES (TB_EAST_GRJCXX_REC (I).KHTYBH,
                         TB_EAST_GRJCXX_REC (I).ZJHM,
                         TB_EAST_GRJCXX_REC (I).YXJGDM,
                         TB_EAST_GRJCXX_REC (I).JRXKZH,
                         TB_EAST_GRJCXX_REC (I).NBJGH,
                         TB_EAST_GRJCXX_REC (I).LYXT,
                         TB_EAST_GRJCXX_REC (I).KHXM,
                         TB_EAST_GRJCXX_REC (I).KHYWXM,
                         TB_EAST_GRJCXX_REC (I).ZJLB,
                         TB_EAST_GRJCXX_REC (I).GJ,
                         TB_EAST_GRJCXX_REC (I).MZ,
                         TB_EAST_GRJCXX_REC (I).XB,
                         TB_EAST_GRJCXX_REC (I).XL,
                         TB_EAST_GRJCXX_REC (I).CSRQ,
                         TB_EAST_GRJCXX_REC (I).GZDWMC,
                         TB_EAST_GRJCXX_REC (I).GZDWDZ,
                         TB_EAST_GRJCXX_REC (I).GZDWDH,
                         TB_EAST_GRJCXX_REC (I).ZY,
                         TB_EAST_GRJCXX_REC (I).JTZZ,
                         TB_EAST_GRJCXX_REC (I).TXDZ,
                         TB_EAST_GRJCXX_REC (I).JTDH,
                         TB_EAST_GRJCXX_REC (I).YDDH,
                         TB_EAST_GRJCXX_REC (I).GRYSR,
                         TB_EAST_GRJCXX_REC (I).JTYSR,
                         TB_EAST_GRJCXX_REC (I).HYQK,
                         TB_EAST_GRJCXX_REC (I).POXM,
                         TB_EAST_GRJCXX_REC (I).POLXDH,
                         TB_EAST_GRJCXX_REC (I).POYDDH,
                         TB_EAST_GRJCXX_REC (I).PODYKHH,
                         TB_EAST_GRJCXX_REC (I).BXYGBZ,
                         TB_EAST_GRJCXX_REC (I).SBXHMDBZ,
                         TB_EAST_GRJCXX_REC (I).SHMDRQ,
                         TB_EAST_GRJCXX_REC (I).SHMDYY,
                         TB_EAST_GRJCXX_REC (I).YZBM,
                         TB_EAST_GRJCXX_REC (I).DWXZ,
                         TB_EAST_GRJCXX_REC (I).ZC,
                         TB_EAST_GRJCXX_REC (I).SFNH,
                         TB_EAST_GRJCXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------EAST_GRJCXX---个人基础信息--END--------------
   ---------------------EAST_GRKHGXXX---个人客户关系信息-----START-----23-------------------
   ELSIF P_TBNAME = 'EAST_GRKHGXXX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRKHGXXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRKHGXXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRKHGXXX_TMP
          WHERE     KHTYBH = TB_EAST_GRKHGXXX_REC (I).KHTYBH
                AND DYGRKHTYBH = TB_EAST_GRKHGXXX_REC (I).DYGRKHTYBH
                AND CJRQ = TB_EAST_GRKHGXXX_REC (I).CJRQ; --    (KHTYBH, DYGRKHTYBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRKHGXXX_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.KHTYBH = TB_EAST_GRKHGXXX_REC (I).KHTYBH
                   AND TP.DYGRKHTYBH = TB_EAST_GRKHGXXX_REC (I).DYGRKHTYBH
                   AND TP.CJRQ = TB_EAST_GRKHGXXX_REC (I).CJRQ; --   (KHTYBH, DYGRKHTYBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRKHGXXX_TMP (KHTYBH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  DYGRKHTYBH,
                                                  SHGX,
                                                  DYGRKHXM,
                                                  DYGRKHGZDWMC,
                                                  DYGRKHGZDWDZ,
                                                  DYGRKHGZDWDH,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_GRKHGXXX_REC (I).KHTYBH,
                         TB_EAST_GRKHGXXX_REC (I).YXJGDM,
                         TB_EAST_GRKHGXXX_REC (I).JRXKZH,
                         TB_EAST_GRKHGXXX_REC (I).NBJGH,
                         TB_EAST_GRKHGXXX_REC (I).DYGRKHTYBH,
                         TB_EAST_GRKHGXXX_REC (I).SHGX,
                         TB_EAST_GRKHGXXX_REC (I).DYGRKHXM,
                         TB_EAST_GRKHGXXX_REC (I).DYGRKHGZDWMC,
                         TB_EAST_GRKHGXXX_REC (I).DYGRKHGZDWDZ,
                         TB_EAST_GRKHGXXX_REC (I).DYGRKHGZDWDH,
                         TB_EAST_GRKHGXXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ------------------EAST_GRKHGXXX---个人客户关系信息--END--------------
   -----------------------EAST_GRXDFHZ---个人信贷分户账-----START-----24-------------------
   ELSIF P_TBNAME = 'EAST_GRXDFHZ'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRXDFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRXDFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRXDFHZ_TMP
          WHERE     DKFHZH = TB_EAST_GRXDFHZ_REC (I).DKFHZH
                AND XDJJH = TB_EAST_GRXDFHZ_REC (I).XDJJH
                AND BZ = TB_EAST_GRXDFHZ_REC (I).BZ
                AND CJRQ = TB_EAST_GRXDFHZ_REC (I).CJRQ; --    (DKFHZH, XDJJH, BZ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRXDFHZ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.DKFHZH = TB_EAST_GRXDFHZ_REC (I).DKFHZH
                   AND TP.XDJJH = TB_EAST_GRXDFHZ_REC (I).XDJJH
                   AND TP.BZ = TB_EAST_GRXDFHZ_REC (I).BZ
                   AND TP.CJRQ = TB_EAST_GRXDFHZ_REC (I).CJRQ; --    (DKFHZH, XDJJH, BZ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRXDFHZ_TMP (DKFHZH,
                                                 XDJJH,
                                                 KHTYBH,
                                                 YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 MXKMBH,
                                                 YXJGMC,
                                                 MXKMMC,
                                                 ZHMC,
                                                 BZ,
                                                 ZJHKRQ,
                                                 TJKMBH,
                                                 DKHTH,
                                                 XDYXM,
                                                 DKWJFL,
                                                 HKZH,
                                                 DKRZZH,
                                                 DKLL,
                                                 DKBJZE,
                                                 DKZCYE,
                                                 DKYQYE,
                                                 QBYE,
                                                 BWQXYE,
                                                 DKQX,
                                                 DQRQ,
                                                 QXRQ,
                                                 KHRQ,
                                                 XHRQ,
                                                 YQRQ,
                                                 ZHZT,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_GRXDFHZ_REC (I).DKFHZH,
                         TB_EAST_GRXDFHZ_REC (I).XDJJH,
                         TB_EAST_GRXDFHZ_REC (I).KHTYBH,
                         TB_EAST_GRXDFHZ_REC (I).YXJGDM,
                         TB_EAST_GRXDFHZ_REC (I).JRXKZH,
                         TB_EAST_GRXDFHZ_REC (I).NBJGH,
                         TB_EAST_GRXDFHZ_REC (I).MXKMBH,
                         TB_EAST_GRXDFHZ_REC (I).YXJGMC,
                         TB_EAST_GRXDFHZ_REC (I).MXKMMC,
                         TB_EAST_GRXDFHZ_REC (I).ZHMC,
                         TB_EAST_GRXDFHZ_REC (I).BZ,
                         TB_EAST_GRXDFHZ_REC (I).ZJHKRQ,
                         TB_EAST_GRXDFHZ_REC (I).TJKMBH,
                         TB_EAST_GRXDFHZ_REC (I).DKHTH,
                         TB_EAST_GRXDFHZ_REC (I).XDYXM,
                         TB_EAST_GRXDFHZ_REC (I).DKWJFL,
                         TB_EAST_GRXDFHZ_REC (I).HKZH,
                         TB_EAST_GRXDFHZ_REC (I).DKRZZH,
                         TB_EAST_GRXDFHZ_REC (I).DKLL,
                         TB_EAST_GRXDFHZ_REC (I).DKBJZE,
                         TB_EAST_GRXDFHZ_REC (I).DKZCYE,
                         TB_EAST_GRXDFHZ_REC (I).DKYQYE,
                         TB_EAST_GRXDFHZ_REC (I).QBYE,
                         TB_EAST_GRXDFHZ_REC (I).BWQXYE,
                         TB_EAST_GRXDFHZ_REC (I).DKQX,
                         TB_EAST_GRXDFHZ_REC (I).DQRQ,
                         TB_EAST_GRXDFHZ_REC (I).QXRQ,
                         TB_EAST_GRXDFHZ_REC (I).KHRQ,
                         TB_EAST_GRXDFHZ_REC (I).XHRQ,
                         TB_EAST_GRXDFHZ_REC (I).YQRQ,
                         TB_EAST_GRXDFHZ_REC (I).ZHZT,
                         TB_EAST_GRXDFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------------------EAST_GRXDFHZ---个人信贷分户账--END--------------
   -------------------------EAST_GRXDFHZMXJLMXJL---个人信贷分户账明细记录-----START---25---------------------
   ELSIF P_TBNAME = 'EAST_GRXDFHZMXJL'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRXDFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRXDFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRXDFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_GRXDFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_GRXDFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_GRXDFHZMXJL_REC (I).BCXH
                AND DKFHZH = TB_EAST_GRXDFHZMXJL_REC (I).DKFHZH
                AND XDJJH = TB_EAST_GRXDFHZMXJL_REC (I).XDJJH
                AND HXJYRQ = TB_EAST_GRXDFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_GRXDFHZMXJL_REC (I).CJRQ; --    (HXJYLSH, ZJYLSH, BCXH, DKFHZH, XDJJH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRXDFHZMXJL_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.HXJYLSH = TB_EAST_GRXDFHZMXJL_REC (I).HXJYLSH
                   AND TP.ZJYLSH = TB_EAST_GRXDFHZMXJL_REC (I).ZJYLSH
                   AND TP.BCXH = TB_EAST_GRXDFHZMXJL_REC (I).BCXH
                   AND TP.DKFHZH = TB_EAST_GRXDFHZMXJL_REC (I).DKFHZH
                   AND TP.XDJJH = TB_EAST_GRXDFHZMXJL_REC (I).XDJJH
                   AND TP.HXJYRQ = TB_EAST_GRXDFHZMXJL_REC (I).HXJYRQ
                   AND TP.CJRQ = TB_EAST_GRXDFHZMXJL_REC (I).CJRQ; --    (HXJYLSH, ZJYLSH, BCXH, DKFHZH, XDJJH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRXDFHZMXJL_TMP (HXJYLSH,
                                                     ZJYLSH,
                                                     BCXH,
                                                     DKFHZH,
                                                     KHTYBH,
                                                     YXJGDM,
                                                     JRXKZH,
                                                     NBJGH,
                                                     MXKMBH,
                                                     XDJJH,
                                                     YXJGMC,
                                                     MXKMMC,
                                                     HXJYRQ,
                                                     HXJYSJ,
                                                     ZHMC,
                                                     JYLX,
                                                     JYJDBZ,
                                                     JYJE,
                                                     ZHYE,
                                                     DFZH,
                                                     DFHM,
                                                     DFXH,
                                                     DFXM,
                                                     JYQD,
                                                     BZ,
                                                     ZY,
                                                     CBMBZ,
                                                     DBRXM,
                                                     DBRZJLB,
                                                     DBRZJHM,
                                                     JYGYH,
                                                     SQGYH,
                                                     XZBZ,
                                                     CJRQ,
                                                     ERRMSG)
                 VALUES (TB_EAST_GRXDFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_GRXDFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_GRXDFHZMXJL_REC (I).BCXH,
                         TB_EAST_GRXDFHZMXJL_REC (I).DKFHZH,
                         TB_EAST_GRXDFHZMXJL_REC (I).KHTYBH,
                         TB_EAST_GRXDFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_GRXDFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_GRXDFHZMXJL_REC (I).NBJGH,
                         TB_EAST_GRXDFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_GRXDFHZMXJL_REC (I).XDJJH,
                         TB_EAST_GRXDFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_GRXDFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_GRXDFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_GRXDFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_GRXDFHZMXJL_REC (I).ZHMC,
                         TB_EAST_GRXDFHZMXJL_REC (I).JYLX,
                         TB_EAST_GRXDFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_GRXDFHZMXJL_REC (I).JYJE,
                         TB_EAST_GRXDFHZMXJL_REC (I).ZHYE,
                         TB_EAST_GRXDFHZMXJL_REC (I).DFZH,
                         TB_EAST_GRXDFHZMXJL_REC (I).DFHM,
                         TB_EAST_GRXDFHZMXJL_REC (I).DFXH,
                         TB_EAST_GRXDFHZMXJL_REC (I).DFXM,
                         TB_EAST_GRXDFHZMXJL_REC (I).JYQD,
                         TB_EAST_GRXDFHZMXJL_REC (I).BZ,
                         TB_EAST_GRXDFHZMXJL_REC (I).ZY,
                         TB_EAST_GRXDFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_GRXDFHZMXJL_REC (I).DBRXM,
                         TB_EAST_GRXDFHZMXJL_REC (I).DBRZJLB,
                         TB_EAST_GRXDFHZMXJL_REC (I).DBRZJHM,
                         TB_EAST_GRXDFHZMXJL_REC (I).JYGYH,
                         TB_EAST_GRXDFHZMXJL_REC (I).SQGYH,
                         TB_EAST_GRXDFHZMXJL_REC (I).XZBZ,
                         TB_EAST_GRXDFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------------EAST_GRXDFHZMXJLMXJL---个人信贷分户账明细记录--END--------------
   ----------------------------个人信贷业务借据-----26----------------------
   ELSIF P_TBNAME = 'EAST_GRXDYWJJ'                              
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GRXDYWJJ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GRXDYWJJ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GRXDYWJJ_TMP
          WHERE     XDJJH = TB_EAST_GRXDYWJJ_REC (I).XDJJH
                AND CJRQ = TB_EAST_GRXDYWJJ_REC (I).CJRQ;    --  (XDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GRXDYWJJ_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.XDJJH = TB_EAST_GRXDYWJJ_REC (I).XDJJH
                   AND TP.CJRQ = TB_EAST_GRXDYWJJ_REC (I).CJRQ; --  (XDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GRXDYWJJ_TMP (XDJJH,
                                                  DKFHZH,
                                                  KHTYBH,
                                                  KHMC,
                                                  XDHTH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  MXKMBH,
                                                  YXJGMC,
                                                  MXKMMC,
                                                  XDYWZL,
                                                  BZ,
                                                  JKJE,
                                                  JKYE,
                                                  DKQX,
                                                  ZQCS,
                                                  ZQS,
                                                  DQQS,
                                                  FKFS,
                                                  DKSJFFRQ,
                                                  DKYSDQRQ,
                                                  DKSJDQRQ,
                                                  BNQXYE,
                                                  BWQXYE,
                                                  DKZT,
                                                  ZJRQ,
                                                  DKLX,
                                                  DKRZZH,
                                                  DKWJFL,
                                                  LLLX,
                                                  JZLL,
                                                  LLFD,
                                                  HKFS,
                                                  HKZH,
                                                  HKQD,
                                                  JXFS,
                                                  BZJBL,
                                                  BZJBZ,
                                                  BZJJE,
                                                  BZJZH,
                                                  XDYXM,
                                                  XDYYGH,
                                                  XZBZ,
                                                  LJQKQS,
                                                  LXQKQS,
                                                  STZFBZ,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_GRXDYWJJ_REC (I).XDJJH,
                         TB_EAST_GRXDYWJJ_REC (I).DKFHZH,
                         TB_EAST_GRXDYWJJ_REC (I).KHTYBH,
                         TB_EAST_GRXDYWJJ_REC (I).KHMC,
                         TB_EAST_GRXDYWJJ_REC (I).XDHTH,
                         TB_EAST_GRXDYWJJ_REC (I).YXJGDM,
                         TB_EAST_GRXDYWJJ_REC (I).JRXKZH,
                         TB_EAST_GRXDYWJJ_REC (I).NBJGH,
                         TB_EAST_GRXDYWJJ_REC (I).MXKMBH,
                         TB_EAST_GRXDYWJJ_REC (I).YXJGMC,
                         TB_EAST_GRXDYWJJ_REC (I).MXKMMC,
                         TB_EAST_GRXDYWJJ_REC (I).XDYWZL,
                         TB_EAST_GRXDYWJJ_REC (I).BZ,
                         TB_EAST_GRXDYWJJ_REC (I).JKJE,
                         TB_EAST_GRXDYWJJ_REC (I).JKYE,
                         TB_EAST_GRXDYWJJ_REC (I).DKQX,
                         TB_EAST_GRXDYWJJ_REC (I).ZQCS,
                         TB_EAST_GRXDYWJJ_REC (I).ZQS,
                         TB_EAST_GRXDYWJJ_REC (I).DQQS,
                         TB_EAST_GRXDYWJJ_REC (I).FKFS,
                         TB_EAST_GRXDYWJJ_REC (I).DKSJFFRQ,
                         TB_EAST_GRXDYWJJ_REC (I).DKYSDQRQ,
                         TB_EAST_GRXDYWJJ_REC (I).DKSJDQRQ,
                         TB_EAST_GRXDYWJJ_REC (I).BNQXYE,
                         TB_EAST_GRXDYWJJ_REC (I).BWQXYE,
                         TB_EAST_GRXDYWJJ_REC (I).DKZT,
                         TB_EAST_GRXDYWJJ_REC (I).ZJRQ,
                         TB_EAST_GRXDYWJJ_REC (I).DKLX,
                         TB_EAST_GRXDYWJJ_REC (I).DKRZZH,
                         TB_EAST_GRXDYWJJ_REC (I).DKWJFL,
                         TB_EAST_GRXDYWJJ_REC (I).LLLX,
                         TB_EAST_GRXDYWJJ_REC (I).JZLL,
                         TB_EAST_GRXDYWJJ_REC (I).LLFD,
                         TB_EAST_GRXDYWJJ_REC (I).HKFS,
                         TB_EAST_GRXDYWJJ_REC (I).HKZH,
                         TB_EAST_GRXDYWJJ_REC (I).HKQD,
                         TB_EAST_GRXDYWJJ_REC (I).JXFS,
                         TB_EAST_GRXDYWJJ_REC (I).BZJBL,
                         TB_EAST_GRXDYWJJ_REC (I).BZJBZ,
                         TB_EAST_GRXDYWJJ_REC (I).BZJJE,
                         TB_EAST_GRXDYWJJ_REC (I).BZJZH,
                         TB_EAST_GRXDYWJJ_REC (I).XDYXM,
                         TB_EAST_GRXDYWJJ_REC (I).XDYYGH,
                         TB_EAST_GRXDYWJJ_REC (I).XZBZ,
                         TB_EAST_GRXDYWJJ_REC (I).LJQKQS,
                         TB_EAST_GRXDYWJJ_REC (I).LXQKQS,
                         TB_EAST_GRXDYWJJ_REC (I).STZFBZ,
                         TB_EAST_GRXDYWJJ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------------------
   -----------------EAST_GWXXB---岗位信息表--START---27-----------------
   ELSIF P_TBNAME = 'EAST_GWXXB'                          --EAST_GWXXB---岗位信息表
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GWXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GWXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GWXXB_TMP
          WHERE     GWBH = TB_EAST_GWXXB_REC (I).GWBH
                AND NBJGH = TB_EAST_GWXXB_REC (I).NBJGH;      -- (GWBH, NBJGH)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GWXXB_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.GWBH = TB_EAST_GWXXB_REC (I).GWBH
                   AND TP.NBJGH = TB_EAST_GWXXB_REC (I).NBJGH; -- (GWBH, NBJGH)
         ELSE
            INSERT INTO REPORT.EAST_GWXXB_TMP (GWBH,
                                               YXJGDM,
                                               NBJGH,
                                               JRXKZH,
                                               GWZL,
                                               GWMC,
                                               GWSM,
                                               GWZT,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_GWXXB_REC (I).GWBH,
                         TB_EAST_GWXXB_REC (I).YXJGDM,
                         TB_EAST_GWXXB_REC (I).NBJGH,
                         TB_EAST_GWXXB_REC (I).JRXKZH,
                         TB_EAST_GWXXB_REC (I).GWZL,
                         TB_EAST_GWXXB_REC (I).GWMC,
                         TB_EAST_GWXXB_REC (I).GWSM,
                         TB_EAST_GWXXB_REC (I).GWZT,
                         TB_EAST_GWXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------EAST_GWXXB---岗位信息表--END-------------------
   ---------------EAST_GYB---柜员表------START------28-------------------------
   ELSIF P_TBNAME = 'EAST_GYB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_GYB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_GYB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_GYB_TMP
          WHERE     GYH = TB_EAST_GYB_REC (I).GYH
                AND NBJGH = TB_EAST_GYB_REC (I).NBJGH
                AND CJRQ = TB_EAST_GYB_REC (I).CJRQ;     -- (GYH, NBJGH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_GYB_TMP TP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     TP.GYH = TB_EAST_GYB_REC (I).GYH
                   AND TP.NBJGH = TB_EAST_GYB_REC (I).NBJGH
                   AND TP.CJRQ = TB_EAST_GYB_REC (I).CJRQ; -- (GYH, NBJGH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_GYB_TMP (GYH,
                                             GH,
                                             YXJGDM,
                                             NBJGH,
                                             ZXJGDM,
                                             JRXKZH,
                                             YXJGMC,
                                             GYLX,
                                             SFSTGY,
                                             KHJLBZ,
                                             JBZWBZ,
                                             QXGLBZ,
                                             YBGLBZ,
                                             XDYBZ,
                                             KGYBZ,
                                             ZHGYBZ,
                                             SQBZ,
                                             SQFW,
                                             GWBH,
                                             GYYHJB,
                                             GYQXJB,
                                             SGRQ,
                                             GWZT,
                                             CJRQ,
                                             ERRMSG)
                 VALUES (TB_EAST_GYB_REC (I).GYH,
                         TB_EAST_GYB_REC (I).GH,
                         TB_EAST_GYB_REC (I).YXJGDM,
                         TB_EAST_GYB_REC (I).NBJGH,
                         TB_EAST_GYB_REC (I).ZXJGDM,
                         TB_EAST_GYB_REC (I).JRXKZH,
                         TB_EAST_GYB_REC (I).YXJGMC,
                         TB_EAST_GYB_REC (I).GYLX,
                         TB_EAST_GYB_REC (I).SFSTGY,
                         TB_EAST_GYB_REC (I).KHJLBZ,
                         TB_EAST_GYB_REC (I).JBZWBZ,
                         TB_EAST_GYB_REC (I).QXGLBZ,
                         TB_EAST_GYB_REC (I).YBGLBZ,
                         TB_EAST_GYB_REC (I).XDYBZ,
                         TB_EAST_GYB_REC (I).KGYBZ,
                         TB_EAST_GYB_REC (I).ZHGYBZ,
                         TB_EAST_GYB_REC (I).SQBZ,
                         TB_EAST_GYB_REC (I).SQFW,
                         TB_EAST_GYB_REC (I).GWBH,
                         TB_EAST_GYB_REC (I).GYYHJB,
                         TB_EAST_GYB_REC (I).GYQXJB,
                         TB_EAST_GYB_REC (I).SGRQ,
                         TB_EAST_GYB_REC (I).GWZT,
                         TB_EAST_GYB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------- --EAST_GYB---柜员表--END-------------------

   -------------------- --EAST_HLXXB---汇率信息表-----START-29-----------------------
   ELSIF P_TBNAME = 'EAST_HLXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_HLXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_HLXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_HLXXB_TMP
          WHERE     WB = TB_EAST_HLXXB_REC (I).WB
                AND BB = TB_EAST_HLXXB_REC (I).BB
                AND HLRQ = TB_EAST_HLXXB_REC (I).HLRQ
                AND CJRQ = TB_EAST_HLXXB_REC (I).CJRQ; --   (WB, BB, HLRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_HLXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     WB = TB_EAST_HLXXB_REC (I).WB
                   AND BB = TB_EAST_HLXXB_REC (I).BB
                   AND HLRQ = TB_EAST_HLXXB_REC (I).HLRQ
                   AND CJRQ = TB_EAST_HLXXB_REC (I).CJRQ; --   (WB, BB, HLRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_HLXXB_TMP (YXJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               YXJGMC,
                                               WB,
                                               BB,
                                               ZJJ,
                                               JZJ,
                                               HLRQ,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_HLXXB_REC (I).YXJGDM,
                         TB_EAST_HLXXB_REC (I).JRXKZH,
                         TB_EAST_HLXXB_REC (I).NBJGH,
                         TB_EAST_HLXXB_REC (I).YXJGMC,
                         TB_EAST_HLXXB_REC (I).WB,
                         TB_EAST_HLXXB_REC (I).BB,
                         TB_EAST_HLXXB_REC (I).ZJJ,
                         TB_EAST_HLXXB_REC (I).JZJ,
                         TB_EAST_HLXXB_REC (I).HLRQ,
                         TB_EAST_HLXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- --EAST_HLXXB---汇率信息表--END--------------
   -------------------- --EAST_JGGXB---机构关系表-----START--30----------------------
   ELSIF P_TBNAME = 'EAST_JGGXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_JGGXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_JGGXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_JGGXB_TMP
          WHERE NBJGH = TB_EAST_JGGXB_REC (I).NBJGH;              --   (NBJGH)

         IF V_CNT > 0
         THEN
            UPDATE EAST_JGGXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE NBJGH = TB_EAST_JGGXB_REC (I).NBJGH;

            INSERT INTO REPORT.EAST_JGGXB_TMP (YHJGDM,
                                               NBJGH,
                                               JRXKZH,
                                               YHJGMC,
                                               YZBM,
                                               SJGLJGDM,
                                               SJGLJGMC,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_JGGXB_REC (I).YHJGDM,
                         TB_EAST_JGGXB_REC (I).NBJGH,
                         TB_EAST_JGGXB_REC (I).JRXKZH,
                         TB_EAST_JGGXB_REC (I).YHJGMC,
                         TB_EAST_JGGXB_REC (I).YZBM,
                         TB_EAST_JGGXB_REC (I).SJGLJGDM,
                         TB_EAST_JGGXB_REC (I).SJGLJGMC,
                         TB_EAST_JGGXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- --EAST_JGGXB---机构关系表--END--------------
   -------------------- --EAST_JJKXX---借记卡信息-----START-------31-----------------
   ELSIF P_TBNAME = 'EAST_JJKXX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_JJKXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_JJKXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_JJKXX_TMP
          WHERE     KH = TB_EAST_JJKXX_REC (I).KH
                AND HQCKZH = TB_EAST_JJKXX_REC (I).HQCKZH
                AND CJRQ = TB_EAST_JJKXX_REC (I).CJRQ;  --  (KH, HQCKZH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_JJKXX_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     KH = TB_EAST_JJKXX_REC (I).KH
                   AND HQCKZH = TB_EAST_JJKXX_REC (I).HQCKZH
                   AND CJRQ = TB_EAST_JJKXX_REC (I).CJRQ; --  (KH, HQCKZH, CJRQ)

            INSERT INTO REPORT.EAST_JJKXX_TMP (KH,
                                               HQCKZH,
                                               KHTYBH,
                                               YXJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               ZJLB,
                                               ZJHM,
                                               JJKCPMC,
                                               KPZT,
                                               YGBZ,
                                               KKRQ,
                                               KKGYH,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_JJKXX_REC (I).KH,
                         TB_EAST_JJKXX_REC (I).HQCKZH,
                         TB_EAST_JJKXX_REC (I).KHTYBH,
                         TB_EAST_JJKXX_REC (I).YXJGDM,
                         TB_EAST_JJKXX_REC (I).JRXKZH,
                         TB_EAST_JJKXX_REC (I).NBJGH,
                         TB_EAST_JJKXX_REC (I).ZJLB,
                         TB_EAST_JJKXX_REC (I).ZJHM,
                         TB_EAST_JJKXX_REC (I).JJKCPMC,
                         TB_EAST_JJKXX_REC (I).KPZT,
                         TB_EAST_JJKXX_REC (I).YGBZ,
                         TB_EAST_JJKXX_REC (I).KKRQ,
                         TB_EAST_JJKXX_REC (I).KKGYH,
                         TB_EAST_JJKXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- --EAST_JJKXX---借记卡信息--END--------------
   -------------------- ---EAST_JRGJXXB--金融工具信息表-----START-----32-------------------
   ELSIF P_TBNAME = 'EAST_JRGJXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_JRGJXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_JRGJXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_JRGJXXB_TMP
          WHERE     JRGJBH = TB_EAST_JRGJXXB_REC (I).JRGJBH
                AND CJRQ = TB_EAST_JRGJXXB_REC (I).CJRQ;    --  (JRGJBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_JRGJXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     JRGJBH = TB_EAST_JRGJXXB_REC (I).JRGJBH
                   AND CJRQ = TB_EAST_JRGJXXB_REC (I).CJRQ; --  (JRGJBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_JRGJXXB_TMP (YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 YXJGMC,
                                                 ZQMC,
                                                 JRGJBH,
                                                 ZCLX,
                                                 BZ,
                                                 FXJG,
                                                 YXCZQYDM,
                                                 FXGB,
                                                 DBJG,
                                                 CPPJ,
                                                 PJJG,
                                                 FXZTPJ,
                                                 JYZHLX,
                                                 PMLL,
                                                 FXJGE,
                                                 FXRQ,
                                                 SSRQ,
                                                 QXRQ,
                                                 DQRQ,
                                                 LLLX,
                                                 HQBS,
                                                 ZJPGJG,
                                                 PGJGSJ,
                                                 YE,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_JRGJXXB_REC (I).YXJGDM,
                         TB_EAST_JRGJXXB_REC (I).JRXKZH,
                         TB_EAST_JRGJXXB_REC (I).NBJGH,
                         TB_EAST_JRGJXXB_REC (I).YXJGMC,
                         TB_EAST_JRGJXXB_REC (I).ZQMC,
                         TB_EAST_JRGJXXB_REC (I).JRGJBH,
                         TB_EAST_JRGJXXB_REC (I).ZCLX,
                         TB_EAST_JRGJXXB_REC (I).BZ,
                         TB_EAST_JRGJXXB_REC (I).FXJG,
                         TB_EAST_JRGJXXB_REC (I).YXCZQYDM,
                         TB_EAST_JRGJXXB_REC (I).FXGB,
                         TB_EAST_JRGJXXB_REC (I).DBJG,
                         TB_EAST_JRGJXXB_REC (I).CPPJ,
                         TB_EAST_JRGJXXB_REC (I).PJJG,
                         TB_EAST_JRGJXXB_REC (I).FXZTPJ,
                         TB_EAST_JRGJXXB_REC (I).JYZHLX,
                         TB_EAST_JRGJXXB_REC (I).PMLL,
                         TB_EAST_JRGJXXB_REC (I).FXJGE,
                         TB_EAST_JRGJXXB_REC (I).FXRQ,
                         TB_EAST_JRGJXXB_REC (I).SSRQ,
                         TB_EAST_JRGJXXB_REC (I).QXRQ,
                         TB_EAST_JRGJXXB_REC (I).DQRQ,
                         TB_EAST_JRGJXXB_REC (I).LLLX,
                         TB_EAST_JRGJXXB_REC (I).HQBS,
                         TB_EAST_JRGJXXB_REC (I).ZJPGJG,
                         TB_EAST_JRGJXXB_REC (I).PGJGSJ,
                         TB_EAST_JRGJXXB_REC (I).YE,
                         TB_EAST_JRGJXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- ---EAST_JRGJXXB--金融工具信息表--END--------------
   -------------------- ----EAST_JYLS---交易流水----START-----33-------------------
   ELSIF P_TBNAME = 'EAST_JYLS'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_JYLS_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_JYLS_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_JYLS_TMP
          WHERE     HXJYLSH = TB_EAST_JYLS_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_JYLS_REC (I).ZJYLSH
                AND BCXH = TB_EAST_JYLS_REC (I).BCXH
                AND JYRQ = TB_EAST_JYLS_REC (I).JYRQ
                AND JYZH = TB_EAST_JYLS_REC (I).JYZH
                AND CJRQ = TB_EAST_JYLS_REC (I).CJRQ; --  (HXJYLSH, ZJYLSH, BCXH, JYRQ, JYZH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_JYLS_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     HXJYLSH = TB_EAST_JYLS_REC (I).HXJYLSH
                   AND ZJYLSH = TB_EAST_JYLS_REC (I).ZJYLSH
                   AND BCXH = TB_EAST_JYLS_REC (I).BCXH
                   AND JYRQ = TB_EAST_JYLS_REC (I).JYRQ
                   AND JYZH = TB_EAST_JYLS_REC (I).JYZH
                   AND CJRQ = TB_EAST_JYLS_REC (I).CJRQ; --  (HXJYLSH, ZJYLSH, BCXH, JYRQ, JYZH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_JYLS_TMP (HXJYLSH,
                                              ZJYLSH,
                                              BCXH,
                                              JYRQ,
                                              YXJGDM,
                                              NBJGH,
                                              JRXKZH,
                                              MXKMBH,
                                              JYSJ,
                                              JZRQ,
                                              JZSJ,
                                              JYJGMC,
                                              JYZH,
                                              JYHM,
                                              JYXTMC,
                                              DFXH,
                                              DFJGMC,
                                              DFZH,
                                              DFHM,
                                              JYJE,
                                              ZHYE,
                                              JYJDBZ,
                                              XZBZ,
                                              BZ,
                                              YWLX,
                                              JYLX,
                                              JYQD,
                                              JYJZMC,
                                              JYJZH,
                                              CZGYH,
                                              GYLSH,
                                              FHGYH,
                                              ZY,
                                              ZPZZL,
                                              ZPZH,
                                              FPZZL,
                                              FPZH,
                                              CBMBZ,
                                              SJC,
                                              ZHBZ,
                                              KXHBZ,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_JYLS_REC (I).HXJYLSH,
                         TB_EAST_JYLS_REC (I).ZJYLSH,
                         TB_EAST_JYLS_REC (I).BCXH,
                         TB_EAST_JYLS_REC (I).JYRQ,
                         TB_EAST_JYLS_REC (I).YXJGDM,
                         TB_EAST_JYLS_REC (I).NBJGH,
                         TB_EAST_JYLS_REC (I).JRXKZH,
                         TB_EAST_JYLS_REC (I).MXKMBH,
                         TB_EAST_JYLS_REC (I).JYSJ,
                         TB_EAST_JYLS_REC (I).JZRQ,
                         TB_EAST_JYLS_REC (I).JZSJ,
                         TB_EAST_JYLS_REC (I).JYJGMC,
                         TB_EAST_JYLS_REC (I).JYZH,
                         TB_EAST_JYLS_REC (I).JYHM,
                         TB_EAST_JYLS_REC (I).JYXTMC,
                         TB_EAST_JYLS_REC (I).DFXH,
                         TB_EAST_JYLS_REC (I).DFJGMC,
                         TB_EAST_JYLS_REC (I).DFZH,
                         TB_EAST_JYLS_REC (I).DFHM,
                         TB_EAST_JYLS_REC (I).JYJE,
                         TB_EAST_JYLS_REC (I).ZHYE,
                         TB_EAST_JYLS_REC (I).JYJDBZ,
                         TB_EAST_JYLS_REC (I).XZBZ,
                         TB_EAST_JYLS_REC (I).BZ,
                         TB_EAST_JYLS_REC (I).YWLX,
                         TB_EAST_JYLS_REC (I).JYLX,
                         TB_EAST_JYLS_REC (I).JYQD,
                         TB_EAST_JYLS_REC (I).JYJZMC,
                         TB_EAST_JYLS_REC (I).JYJZH,
                         TB_EAST_JYLS_REC (I).CZGYH,
                         TB_EAST_JYLS_REC (I).GYLSH,
                         TB_EAST_JYLS_REC (I).FHGYH,
                         TB_EAST_JYLS_REC (I).ZY,
                         TB_EAST_JYLS_REC (I).ZPZZL,
                         TB_EAST_JYLS_REC (I).ZPZH,
                         TB_EAST_JYLS_REC (I).FPZZL,
                         TB_EAST_JYLS_REC (I).FPZH,
                         TB_EAST_JYLS_REC (I).CBMBZ,
                         TB_EAST_JYLS_REC (I).SJC,
                         TB_EAST_JYLS_REC (I).ZHBZ,
                         TB_EAST_JYLS_REC (I).KXHBZ,
                         TB_EAST_JYLS_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- ----EAST_JYLS---交易流水-END--------------
   -------------------- ---EAST_KHLCZHXXB---客户理财账户信息表----START----34--------------------
   ELSIF P_TBNAME = 'EAST_KHLCZHXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_KHLCZHXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_KHLCZHXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_KHLCZHXXB_TMP
          WHERE     LCZH = TB_EAST_KHLCZHXXB_REC (I).LCZH
                AND GLHQCKZH = TB_EAST_KHLCZHXXB_REC (I).GLHQCKZH
                AND HNBSM = TB_EAST_KHLCZHXXB_REC (I).HNBSM
                AND CJRQ = TB_EAST_KHLCZHXXB_REC (I).CJRQ; -- (LCZH, GLHQCKZH, HNBSM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_KHLCZHXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     LCZH = TB_EAST_KHLCZHXXB_REC (I).LCZH
                   AND GLHQCKZH = TB_EAST_KHLCZHXXB_REC (I).GLHQCKZH
                   AND HNBSM = TB_EAST_KHLCZHXXB_REC (I).HNBSM
                   AND CJRQ = TB_EAST_KHLCZHXXB_REC (I).CJRQ; -- (LCZH, GLHQCKZH, HNBSM, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_KHLCZHXXB_TMP (YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   YXJGMC,
                                                   MXKMMC,
                                                   BZ,
                                                   LCZH,
                                                   KHTYBH,
                                                   KHXM,
                                                   GLHQCKZH,
                                                   LCCPMC,
                                                   HNBSM,
                                                   FEZS,
                                                   DJFE,
                                                   HLZTZBZ,
                                                   BQSY,
                                                   LJSY,
                                                   MRCB,
                                                   BQQSRQ,
                                                   BQDQRQ,
                                                   KHRQ,
                                                   SCDHRQ,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_KHLCZHXXB_REC (I).YXJGDM,
                         TB_EAST_KHLCZHXXB_REC (I).JRXKZH,
                         TB_EAST_KHLCZHXXB_REC (I).NBJGH,
                         TB_EAST_KHLCZHXXB_REC (I).MXKMBH,
                         TB_EAST_KHLCZHXXB_REC (I).YXJGMC,
                         TB_EAST_KHLCZHXXB_REC (I).MXKMMC,
                         TB_EAST_KHLCZHXXB_REC (I).BZ,
                         TB_EAST_KHLCZHXXB_REC (I).LCZH,
                         TB_EAST_KHLCZHXXB_REC (I).KHTYBH,
                         TB_EAST_KHLCZHXXB_REC (I).KHXM,
                         TB_EAST_KHLCZHXXB_REC (I).GLHQCKZH,
                         TB_EAST_KHLCZHXXB_REC (I).LCCPMC,
                         TB_EAST_KHLCZHXXB_REC (I).HNBSM,
                         TB_EAST_KHLCZHXXB_REC (I).FEZS,
                         TB_EAST_KHLCZHXXB_REC (I).DJFE,
                         TB_EAST_KHLCZHXXB_REC (I).HLZTZBZ,
                         TB_EAST_KHLCZHXXB_REC (I).BQSY,
                         TB_EAST_KHLCZHXXB_REC (I).LJSY,
                         TB_EAST_KHLCZHXXB_REC (I).MRCB,
                         TB_EAST_KHLCZHXXB_REC (I).BQQSRQ,
                         TB_EAST_KHLCZHXXB_REC (I).BQDQRQ,
                         TB_EAST_KHLCZHXXB_REC (I).KHRQ,
                         TB_EAST_KHLCZHXXB_REC (I).SCDHRQ,
                         TB_EAST_KHLCZHXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- ---EAST_KHLCZHXXB---客户理财账户信息表-END--------------
   -------------------- ------EAST_LCCPXSMX---理财产品销售明细记录----START-----35-------------------
   ELSIF P_TBNAME = 'EAST_LCCPXSMX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_LCCPXSMX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_LCCPXSMX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_LCCPXSMX_TMP
          WHERE     HXJYLSH = TB_EAST_LCCPXSMX_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_LCCPXSMX_REC (I).ZJYLSH
                AND BCXH = TB_EAST_LCCPXSMX_REC (I).BCXH
                AND HXJYRQ = TB_EAST_LCCPXSMX_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_LCCPXSMX_REC (I).CJRQ; --(HXJYLSH, ZJYLSH, BCXH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_LCCPXSMX_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     HXJYLSH = TB_EAST_LCCPXSMX_REC (I).HXJYLSH
                   AND ZJYLSH = TB_EAST_LCCPXSMX_REC (I).ZJYLSH
                   AND BCXH = TB_EAST_LCCPXSMX_REC (I).BCXH
                   AND HXJYRQ = TB_EAST_LCCPXSMX_REC (I).HXJYRQ
                   AND CJRQ = TB_EAST_LCCPXSMX_REC (I).CJRQ; --(HXJYLSH, ZJYLSH, BCXH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_LCCPXSMX_TMP (JYH,
                                                  HXJYLSH,
                                                  ZJYLSH,
                                                  BCXH,
                                                  YXJGDM,
                                                  JRXKZH,
                                                  NBJGH,
                                                  MXKMBH,
                                                  YXJGMC,
                                                  MXKMMC,
                                                  LCZH,
                                                  KHTYBH,
                                                  KHXM,
                                                  GLHQCKZH,
                                                  LCCPMC,
                                                  HNBSM,
                                                  SGSHBZ,
                                                  BZ,
                                                  HXJYRQ,
                                                  JYJE,
                                                  JYFE,
                                                  JYFY,
                                                  JYQD,
                                                  KHJLGH,
                                                  KHJLXM,
                                                  JYGYH,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_LCCPXSMX_REC (I).JYH,
                         TB_EAST_LCCPXSMX_REC (I).HXJYLSH,
                         TB_EAST_LCCPXSMX_REC (I).ZJYLSH,
                         TB_EAST_LCCPXSMX_REC (I).BCXH,
                         TB_EAST_LCCPXSMX_REC (I).YXJGDM,
                         TB_EAST_LCCPXSMX_REC (I).JRXKZH,
                         TB_EAST_LCCPXSMX_REC (I).NBJGH,
                         TB_EAST_LCCPXSMX_REC (I).MXKMBH,
                         TB_EAST_LCCPXSMX_REC (I).YXJGMC,
                         TB_EAST_LCCPXSMX_REC (I).MXKMMC,
                         TB_EAST_LCCPXSMX_REC (I).LCZH,
                         TB_EAST_LCCPXSMX_REC (I).KHTYBH,
                         TB_EAST_LCCPXSMX_REC (I).KHXM,
                         TB_EAST_LCCPXSMX_REC (I).GLHQCKZH,
                         TB_EAST_LCCPXSMX_REC (I).LCCPMC,
                         TB_EAST_LCCPXSMX_REC (I).HNBSM,
                         TB_EAST_LCCPXSMX_REC (I).SGSHBZ,
                         TB_EAST_LCCPXSMX_REC (I).BZ,
                         TB_EAST_LCCPXSMX_REC (I).HXJYRQ,
                         TB_EAST_LCCPXSMX_REC (I).JYJE,
                         TB_EAST_LCCPXSMX_REC (I).JYFE,
                         TB_EAST_LCCPXSMX_REC (I).JYFY,
                         TB_EAST_LCCPXSMX_REC (I).JYQD,
                         TB_EAST_LCCPXSMX_REC (I).KHJLGH,
                         TB_EAST_LCCPXSMX_REC (I).KHJLXM,
                         TB_EAST_LCCPXSMX_REC (I).JYGYH,
                         TB_EAST_LCCPXSMX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- ------EAST_LCCPXSMX---理财产品销售明细记录-END--------------
   -----------------------EAST_LCCPXXB---理财产品信息表----START------36------------------
   ELSIF P_TBNAME = 'EAST_LCCPXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_LCCPXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_LCCPXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_LCCPXXB_TMP
          WHERE     HNBSM = TB_EAST_LCCPXXB_REC (I).HNBSM
                AND CJRQ = TB_EAST_LCCPXXB_REC (I).CJRQ;      -- (HNBSM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_LCCPXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     HNBSM = TB_EAST_LCCPXXB_REC (I).HNBSM
                   AND CJRQ = TB_EAST_LCCPXXB_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_LCCPXXB_TMP (YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 MXKMBH,
                                                 YXJGMC,
                                                 MXKMMC,
                                                 CPMC,
                                                 CPDJBM,
                                                 HNBSM,
                                                 CPPP,
                                                 CPQC,
                                                 CPSPRSFZH,
                                                 CPSPRXM,
                                                 CPSJRSFZH,
                                                 CPSJRXM,
                                                 TZJLSFZH,
                                                 TZJLXM,
                                                 CPSYLX,
                                                 CPQX,
                                                 TZZLX,
                                                 ZJTXDQ,
                                                 CPTZGJHDQ,
                                                 LCYWFWMS,
                                                 CPYZMS,
                                                 KJHSFS,
                                                 CPZCPZFS,
                                                 CPGLMS,
                                                 SJGLLMC,
                                                 CPDJFS,
                                                 TZLX,
                                                 HZMS,
                                                 HZJGMC,
                                                 TZZCZLJBL,
                                                 SFYYQSYL,
                                                 YJKHZGNSYL,
                                                 YJKHZDNSYL,
                                                 SFYSYLCSYJ,
                                                 TZZFXPH,
                                                 CPXSQY,
                                                 MJBZ,
                                                 DFBJBZ,
                                                 DFSYBZ,
                                                 QDXSJE,
                                                 JHMJJE,
                                                 MJQSRQ,
                                                 TZBJDZR,
                                                 TZSYDZR,
                                                 XSSXFL,
                                                 JNTGJGMC,
                                                 JNTGJGDM,
                                                 JWTGJGGB,
                                                 JWTGJGMC,
                                                 LCCPZJTGZH,
                                                 LCCPZJTGZHMC,
                                                 TGFL,
                                                 CPFXDJ,
                                                 FXJGTQZZQBS,
                                                 KHSHQBS,
                                                 CPZXBS,
                                                 CPZXJGLX,
                                                 CPZXXS,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_LCCPXXB_REC (I).YXJGDM,
                         TB_EAST_LCCPXXB_REC (I).JRXKZH,
                         TB_EAST_LCCPXXB_REC (I).NBJGH,
                         TB_EAST_LCCPXXB_REC (I).MXKMBH,
                         TB_EAST_LCCPXXB_REC (I).YXJGMC,
                         TB_EAST_LCCPXXB_REC (I).MXKMMC,
                         TB_EAST_LCCPXXB_REC (I).CPMC,
                         TB_EAST_LCCPXXB_REC (I).CPDJBM,
                         TB_EAST_LCCPXXB_REC (I).HNBSM,
                         TB_EAST_LCCPXXB_REC (I).CPPP,
                         TB_EAST_LCCPXXB_REC (I).CPQC,
                         TB_EAST_LCCPXXB_REC (I).CPSPRSFZH,
                         TB_EAST_LCCPXXB_REC (I).CPSPRXM,
                         TB_EAST_LCCPXXB_REC (I).CPSJRSFZH,
                         TB_EAST_LCCPXXB_REC (I).CPSJRXM,
                         TB_EAST_LCCPXXB_REC (I).TZJLSFZH,
                         TB_EAST_LCCPXXB_REC (I).TZJLXM,
                         TB_EAST_LCCPXXB_REC (I).CPSYLX,
                         TB_EAST_LCCPXXB_REC (I).CPQX,
                         TB_EAST_LCCPXXB_REC (I).TZZLX,
                         TB_EAST_LCCPXXB_REC (I).ZJTXDQ,
                         TB_EAST_LCCPXXB_REC (I).CPTZGJHDQ,
                         TB_EAST_LCCPXXB_REC (I).LCYWFWMS,
                         TB_EAST_LCCPXXB_REC (I).CPYZMS,
                         TB_EAST_LCCPXXB_REC (I).KJHSFS,
                         TB_EAST_LCCPXXB_REC (I).CPZCPZFS,
                         TB_EAST_LCCPXXB_REC (I).CPGLMS,
                         TB_EAST_LCCPXXB_REC (I).SJGLLMC,
                         TB_EAST_LCCPXXB_REC (I).CPDJFS,
                         TB_EAST_LCCPXXB_REC (I).TZLX,
                         TB_EAST_LCCPXXB_REC (I).HZMS,
                         TB_EAST_LCCPXXB_REC (I).HZJGMC,
                         TB_EAST_LCCPXXB_REC (I).TZZCZLJBL,
                         TB_EAST_LCCPXXB_REC (I).SFYYQSYL,
                         TB_EAST_LCCPXXB_REC (I).YJKHZGNSYL,
                         TB_EAST_LCCPXXB_REC (I).YJKHZDNSYL,
                         TB_EAST_LCCPXXB_REC (I).SFYSYLCSYJ,
                         TB_EAST_LCCPXXB_REC (I).TZZFXPH,
                         TB_EAST_LCCPXXB_REC (I).CPXSQY,
                         TB_EAST_LCCPXXB_REC (I).MJBZ,
                         TB_EAST_LCCPXXB_REC (I).DFBJBZ,
                         TB_EAST_LCCPXXB_REC (I).DFSYBZ,
                         TB_EAST_LCCPXXB_REC (I).QDXSJE,
                         TB_EAST_LCCPXXB_REC (I).JHMJJE,
                         TB_EAST_LCCPXXB_REC (I).MJQSRQ,
                         TB_EAST_LCCPXXB_REC (I).TZBJDZR,
                         TB_EAST_LCCPXXB_REC (I).TZSYDZR,
                         TB_EAST_LCCPXXB_REC (I).XSSXFL,
                         TB_EAST_LCCPXXB_REC (I).JNTGJGMC,
                         TB_EAST_LCCPXXB_REC (I).JNTGJGDM,
                         TB_EAST_LCCPXXB_REC (I).JWTGJGGB,
                         TB_EAST_LCCPXXB_REC (I).JWTGJGMC,
                         TB_EAST_LCCPXXB_REC (I).LCCPZJTGZH,
                         TB_EAST_LCCPXXB_REC (I).LCCPZJTGZHMC,
                         TB_EAST_LCCPXXB_REC (I).TGFL,
                         TB_EAST_LCCPXXB_REC (I).CPFXDJ,
                         TB_EAST_LCCPXXB_REC (I).FXJGTQZZQBS,
                         TB_EAST_LCCPXXB_REC (I).KHSHQBS,
                         TB_EAST_LCCPXXB_REC (I).CPZXBS,
                         TB_EAST_LCCPXXB_REC (I).CPZXJGLX,
                         TB_EAST_LCCPXXB_REC (I).CPZXXS,
                         TB_EAST_LCCPXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------------------EAST_LCCPXXB---理财产品信息表-END--------------

   ----------------- -----EAST_LCCPZTB---理财产品状态表START---37----------------
   ELSIF P_TBNAME = 'EAST_LCCPZTB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_LCCPZTB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_LCCPZTB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_LCCPZTB_TMP
          WHERE     HNBSM = TB_EAST_LCCPZTB_REC (I).HNBSM
                AND CJRQ = TB_EAST_LCCPZTB_REC (I).CJRQ;      -- (HNBSM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_LCCPZTB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     HNBSM = TB_EAST_LCCPZTB_REC (I).HNBSM
                   AND CJRQ = TB_EAST_LCCPZTB_REC (I).CJRQ;   -- (HNBSM, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_LCCPZTB_TMP (YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 YXJGMC,
                                                 LCCPMC,
                                                 HNBSM,
                                                 SJMJJE,
                                                 CPQSRQ,
                                                 CPYJZZRQ,
                                                 FXDJR,
                                                 YHDSJSXSR,
                                                 DFKHSY,
                                                 KHDSJNHSYL,
                                                 CPDSJNHSYL,
                                                 ZZDJR,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_LCCPZTB_REC (I).YXJGDM,
                         TB_EAST_LCCPZTB_REC (I).JRXKZH,
                         TB_EAST_LCCPZTB_REC (I).NBJGH,
                         TB_EAST_LCCPZTB_REC (I).YXJGMC,
                         TB_EAST_LCCPZTB_REC (I).LCCPMC,
                         TB_EAST_LCCPZTB_REC (I).HNBSM,
                         TB_EAST_LCCPZTB_REC (I).SJMJJE,
                         TB_EAST_LCCPZTB_REC (I).CPQSRQ,
                         TB_EAST_LCCPZTB_REC (I).CPYJZZRQ,
                         TB_EAST_LCCPZTB_REC (I).FXDJR,
                         TB_EAST_LCCPZTB_REC (I).YHDSJSXSR,
                         TB_EAST_LCCPZTB_REC (I).DFKHSY,
                         TB_EAST_LCCPZTB_REC (I).KHDSJNHSYL,
                         TB_EAST_LCCPZTB_REC (I).CPDSJNHSYL,
                         TB_EAST_LCCPZTB_REC (I).ZZDJR,
                         TB_EAST_LCCPZTB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------- -----EAST_LCCPZTB---理财产品状态表-END-------------------


   --------------------EAST_MYRZYWXXB---贸易融资业务信息表START----38----------------
   ELSIF P_TBNAME = 'EAST_MYRZYWXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_MYRZYWXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_MYRZYWXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_MYRZYWXXB_TMP
          WHERE     DGXDJJH = TB_EAST_MYRZYWXXB_REC (I).DGXDJJH
                AND CJRQ = TB_EAST_MYRZYWXXB_REC (I).CJRQ;  -- (DGXDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_MYRZYWXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     DGXDJJH = TB_EAST_MYRZYWXXB_REC (I).DGXDJJH
                   AND CJRQ = TB_EAST_MYRZYWXXB_REC (I).CJRQ; -- (DGXDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_MYRZYWXXB_TMP (DGXDJJH,
                                                   XDHTH,
                                                   KHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   JKRMC,
                                                   ZZJGDM,
                                                   MYRZPZ,
                                                   MYHTH,
                                                   BZ,
                                                   MYHTZJE,
                                                   BNYE,
                                                   BWYE,
                                                   YXGJYWBH,
                                                   SYFPHM,
                                                   SYFPBZ,
                                                   SYFPJE,
                                                   SYFPZL,
                                                   XYZCDX,
                                                   FFTZL,
                                                   XYZBH,
                                                   XYZBZ,
                                                   XYZJE,
                                                   XYZKZRQ,
                                                   XYZQXLX,
                                                   XYZXQ,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_MYRZYWXXB_REC (I).DGXDJJH,
                         TB_EAST_MYRZYWXXB_REC (I).XDHTH,
                         TB_EAST_MYRZYWXXB_REC (I).KHTYBH,
                         TB_EAST_MYRZYWXXB_REC (I).YXJGDM,
                         TB_EAST_MYRZYWXXB_REC (I).JRXKZH,
                         TB_EAST_MYRZYWXXB_REC (I).NBJGH,
                         TB_EAST_MYRZYWXXB_REC (I).JKRMC,
                         TB_EAST_MYRZYWXXB_REC (I).ZZJGDM,
                         TB_EAST_MYRZYWXXB_REC (I).MYRZPZ,
                         TB_EAST_MYRZYWXXB_REC (I).MYHTH,
                         TB_EAST_MYRZYWXXB_REC (I).BZ,
                         TB_EAST_MYRZYWXXB_REC (I).MYHTZJE,
                         TB_EAST_MYRZYWXXB_REC (I).BNYE,
                         TB_EAST_MYRZYWXXB_REC (I).BWYE,
                         TB_EAST_MYRZYWXXB_REC (I).YXGJYWBH,
                         TB_EAST_MYRZYWXXB_REC (I).SYFPHM,
                         TB_EAST_MYRZYWXXB_REC (I).SYFPBZ,
                         TB_EAST_MYRZYWXXB_REC (I).SYFPJE,
                         TB_EAST_MYRZYWXXB_REC (I).SYFPZL,
                         TB_EAST_MYRZYWXXB_REC (I).XYZCDX,
                         TB_EAST_MYRZYWXXB_REC (I).FFTZL,
                         TB_EAST_MYRZYWXXB_REC (I).XYZBH,
                         TB_EAST_MYRZYWXXB_REC (I).XYZBZ,
                         TB_EAST_MYRZYWXXB_REC (I).XYZJE,
                         TB_EAST_MYRZYWXXB_REC (I).XYZKZRQ,
                         TB_EAST_MYRZYWXXB_REC (I).XYZQXLX,
                         TB_EAST_MYRZYWXXB_REC (I).XYZXQ,
                         TB_EAST_MYRZYWXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ------------EAST_MYRZYWXXB---贸易融资业务信息表-END-------------------


   -----------------------EAST_NBFHZ---内部分户账---START-----39---------------
   ELSIF P_TBNAME = 'EAST_NBFHZ'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_NBFHZ_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_NBFHZ_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_NBFHZ_TMP
          WHERE     NBFHZZH = TB_EAST_NBFHZ_REC (I).NBFHZZH
                AND BZ = TB_EAST_NBFHZ_REC (I).BZ
                AND CJRQ = TB_EAST_NBFHZ_REC (I).CJRQ;   --(NBFHZZH, BZ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_NBFHZ_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     NBFHZZH = TB_EAST_NBFHZ_REC (I).NBFHZZH
                   AND BZ = TB_EAST_NBFHZ_REC (I).BZ
                   AND CJRQ = TB_EAST_NBFHZ_REC (I).CJRQ; --(NBFHZZH, BZ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_NBFHZ_TMP (NBFHZZH,
                                               YXJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               MXKMBH,
                                               ZHMC,
                                               YXJGMC,
                                               MXKMMC,
                                               JDBZ,
                                               BZ,
                                               TJKMBH,
                                               NBFHZZHLX,
                                               JFYE,
                                               DFYE,
                                               JXBZ,
                                               JXFS,
                                               LL,
                                               KHRQ,
                                               XHRQ,
                                               ZHZT,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_NBFHZ_REC (I).NBFHZZH,
                         TB_EAST_NBFHZ_REC (I).YXJGDM,
                         TB_EAST_NBFHZ_REC (I).JRXKZH,
                         TB_EAST_NBFHZ_REC (I).NBJGH,
                         TB_EAST_NBFHZ_REC (I).MXKMBH,
                         TB_EAST_NBFHZ_REC (I).ZHMC,
                         TB_EAST_NBFHZ_REC (I).YXJGMC,
                         TB_EAST_NBFHZ_REC (I).MXKMMC,
                         TB_EAST_NBFHZ_REC (I).JDBZ,
                         TB_EAST_NBFHZ_REC (I).BZ,
                         TB_EAST_NBFHZ_REC (I).TJKMBH,
                         TB_EAST_NBFHZ_REC (I).NBFHZZHLX,
                         TB_EAST_NBFHZ_REC (I).JFYE,
                         TB_EAST_NBFHZ_REC (I).DFYE,
                         TB_EAST_NBFHZ_REC (I).JXBZ,
                         TB_EAST_NBFHZ_REC (I).JXFS,
                         TB_EAST_NBFHZ_REC (I).LL,
                         TB_EAST_NBFHZ_REC (I).KHRQ,
                         TB_EAST_NBFHZ_REC (I).XHRQ,
                         TB_EAST_NBFHZ_REC (I).ZHZT,
                         TB_EAST_NBFHZ_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_NBFHZ---内部分户账-END-------------------

   -----------------------EAST_NBFHZMXJL---内部分户账明细记录---START--40------------------
   ELSIF P_TBNAME = 'EAST_NBFHZMXJL'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_NBFHZMXJL_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_NBFHZMXJL_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_NBFHZMXJL_TMP
          WHERE     HXJYLSH = TB_EAST_NBFHZMXJL_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_NBFHZMXJL_REC (I).ZJYLSH
                AND BCXH = TB_EAST_NBFHZMXJL_REC (I).BCXH
                AND NBFHZZH = TB_EAST_NBFHZMXJL_REC (I).NBFHZZH
                AND HXJYRQ = TB_EAST_NBFHZMXJL_REC (I).HXJYRQ
                AND CJRQ = TB_EAST_NBFHZMXJL_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, NBFHZZH, HXJYRQ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_NBFHZMXJL_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     HXJYLSH = TB_EAST_NBFHZMXJL_REC (I).HXJYLSH
                   AND ZJYLSH = TB_EAST_NBFHZMXJL_REC (I).ZJYLSH
                   AND BCXH = TB_EAST_NBFHZMXJL_REC (I).BCXH
                   AND NBFHZZH = TB_EAST_NBFHZMXJL_REC (I).NBFHZZH
                   AND HXJYRQ = TB_EAST_NBFHZMXJL_REC (I).HXJYRQ
                   AND CJRQ = TB_EAST_NBFHZMXJL_REC (I).CJRQ; -- (HXJYLSH, ZJYLSH, BCXH, NBFHZZH, HXJYRQ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_NBFHZMXJL_TMP (HXJYLSH,
                                                   ZJYLSH,
                                                   BCXH,
                                                   NBFHZZH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   MXKMBH,
                                                   YXJGMC,
                                                   MXKMMC,
                                                   HXJYRQ,
                                                   HXJYSJ,
                                                   BZ,
                                                   ZHMC,
                                                   JYLX,
                                                   JYJE,
                                                   ZHYE,
                                                   DFZH,
                                                   DFKMBH,
                                                   DFKMMC,
                                                   DFHM,
                                                   DFXH,
                                                   JYQD,
                                                   XZBZ,
                                                   JYGYH,
                                                   SQGYH,
                                                   JZRQ,
                                                   XZRQ,
                                                   ZY,
                                                   CBMBZ,
                                                   JYJDBZ,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_NBFHZMXJL_REC (I).HXJYLSH,
                         TB_EAST_NBFHZMXJL_REC (I).ZJYLSH,
                         TB_EAST_NBFHZMXJL_REC (I).BCXH,
                         TB_EAST_NBFHZMXJL_REC (I).NBFHZZH,
                         TB_EAST_NBFHZMXJL_REC (I).YXJGDM,
                         TB_EAST_NBFHZMXJL_REC (I).JRXKZH,
                         TB_EAST_NBFHZMXJL_REC (I).NBJGH,
                         TB_EAST_NBFHZMXJL_REC (I).MXKMBH,
                         TB_EAST_NBFHZMXJL_REC (I).YXJGMC,
                         TB_EAST_NBFHZMXJL_REC (I).MXKMMC,
                         TB_EAST_NBFHZMXJL_REC (I).HXJYRQ,
                         TB_EAST_NBFHZMXJL_REC (I).HXJYSJ,
                         TB_EAST_NBFHZMXJL_REC (I).BZ,
                         TB_EAST_NBFHZMXJL_REC (I).ZHMC,
                         TB_EAST_NBFHZMXJL_REC (I).JYLX,
                         TB_EAST_NBFHZMXJL_REC (I).JYJE,
                         TB_EAST_NBFHZMXJL_REC (I).ZHYE,
                         TB_EAST_NBFHZMXJL_REC (I).DFZH,
                         TB_EAST_NBFHZMXJL_REC (I).DFKMBH,
                         TB_EAST_NBFHZMXJL_REC (I).DFKMMC,
                         TB_EAST_NBFHZMXJL_REC (I).DFHM,
                         TB_EAST_NBFHZMXJL_REC (I).DFXH,
                         TB_EAST_NBFHZMXJL_REC (I).JYQD,
                         TB_EAST_NBFHZMXJL_REC (I).XZBZ,
                         TB_EAST_NBFHZMXJL_REC (I).JYGYH,
                         TB_EAST_NBFHZMXJL_REC (I).SQGYH,
                         TB_EAST_NBFHZMXJL_REC (I).JZRQ,
                         TB_EAST_NBFHZMXJL_REC (I).XZRQ,
                         TB_EAST_NBFHZMXJL_REC (I).ZY,
                         TB_EAST_NBFHZMXJL_REC (I).CBMBZ,
                         TB_EAST_NBFHZMXJL_REC (I).JYJDBZ,
                         TB_EAST_NBFHZMXJL_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_NBFHZMXJLMXJL---内部分户账明细记录-END-------------------



   -----------------------EAST_NBKMDZB---内部科目对照表---START----41----------------
   ELSIF P_TBNAME = 'EAST_NBKMDZB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_NBKMDZB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_NBKMDZB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_NBKMDZB_TMP
          WHERE     KMBH = TB_EAST_NBKMDZB_REC (I).KMBH
                AND CJRQ = TB_EAST_NBKMDZB_REC (I).CJRQ;        --(KMBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_NBKMDZB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     KMBH = TB_EAST_NBKMDZB_REC (I).KMBH
                   AND CJRQ = TB_EAST_NBKMDZB_REC (I).CJRQ;  -- --(KMBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_NBKMDZB_TMP (KMBH,
                                                 KMMC,
                                                 KJKMJC,
                                                 SJKMBH,
                                                 SJKMMC,
                                                 GSYWDL,
                                                 GSYWZL,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_NBKMDZB_REC (I).KMBH,
                         TB_EAST_NBKMDZB_REC (I).KMMC,
                         TB_EAST_NBKMDZB_REC (I).KJKMJC,
                         TB_EAST_NBKMDZB_REC (I).SJKMBH,
                         TB_EAST_NBKMDZB_REC (I).SJKMMC,
                         TB_EAST_NBKMDZB_REC (I).GSYWDL,
                         TB_EAST_NBKMDZB_REC (I).GSYWZL,
                         TB_EAST_NBKMDZB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_NBKMDZBMXJL---内部分户账明细记录-END-------------------


   -----------------------EAST_PJPMXXB---票据票面信息表---START----42----------------
   ELSIF P_TBNAME = 'EAST_PJPMXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_PJPMXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_PJPMXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_PJPMXXB_TMP
          WHERE     PJHM = TB_EAST_PJPMXXB_REC (I).PJHM
                AND CJRQ = TB_EAST_PJPMXXB_REC (I).CJRQ;        --(PJHM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_PJPMXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     PJHM = TB_EAST_PJPMXXB_REC (I).PJHM
                   AND CJRQ = TB_EAST_PJPMXXB_REC (I).CJRQ;   -- -(PJHM, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_PJPMXXB_TMP (PJHM,
                                                 CPRBH,
                                                 FKXDM,
                                                 YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 PJLX,
                                                 CPRQC,
                                                 CPRZH,
                                                 FKXMC,
                                                 BZ,
                                                 PMJE,
                                                 QFRQ,
                                                 PJDQRQ,
                                                 SKRMC,
                                                 SKRZH,
                                                 SKRKHX,
                                                 SYFPHM,
                                                 SYFPBZ,
                                                 SYFPJE,
                                                 SYFPZL,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_PJPMXXB_REC (I).PJHM,
                         TB_EAST_PJPMXXB_REC (I).CPRBH,
                         TB_EAST_PJPMXXB_REC (I).FKXDM,
                         TB_EAST_PJPMXXB_REC (I).YXJGDM,
                         TB_EAST_PJPMXXB_REC (I).JRXKZH,
                         TB_EAST_PJPMXXB_REC (I).NBJGH,
                         TB_EAST_PJPMXXB_REC (I).PJLX,
                         TB_EAST_PJPMXXB_REC (I).CPRQC,
                         TB_EAST_PJPMXXB_REC (I).CPRZH,
                         TB_EAST_PJPMXXB_REC (I).FKXMC,
                         TB_EAST_PJPMXXB_REC (I).BZ,
                         TB_EAST_PJPMXXB_REC (I).PMJE,
                         TB_EAST_PJPMXXB_REC (I).QFRQ,
                         TB_EAST_PJPMXXB_REC (I).PJDQRQ,
                         TB_EAST_PJPMXXB_REC (I).SKRMC,
                         TB_EAST_PJPMXXB_REC (I).SKRZH,
                         TB_EAST_PJPMXXB_REC (I).SKRKHX,
                         TB_EAST_PJPMXXB_REC (I).SYFPHM,
                         TB_EAST_PJPMXXB_REC (I).SYFPBZ,
                         TB_EAST_PJPMXXB_REC (I).SYFPJE,
                         TB_EAST_PJPMXXB_REC (I).SYFPZL,
                         TB_EAST_PJPMXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_PJPMXXBMXJL---内部分户账明细记录-END-------------------

   -------------------------EAST_SNTJB---涉农统计表---START---43-----------------
   ELSIF P_TBNAME = 'EAST_SNTJB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_SNTJB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_SNTJB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_SNTJB_TMP
          WHERE     NBJGH = TB_EAST_SNTJB_REC (I).NBJGH
                AND TJKMBH = TB_EAST_SNTJB_REC (I).TJKMBH
                AND QXLX = TB_EAST_SNTJB_REC (I).QXLX
                AND TJRQ = TB_EAST_SNTJB_REC (I).TJRQ
                AND BZ = TB_EAST_SNTJB_REC (I).BZ
                AND CJRQ = TB_EAST_SNTJB_REC (I).CJRQ; --(NBJGH, TJKMBH, QXLX, TJRQ, BZ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_SNTJB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     NBJGH = TB_EAST_SNTJB_REC (I).NBJGH
                   AND TJKMBH = TB_EAST_SNTJB_REC (I).TJKMBH
                   AND QXLX = TB_EAST_SNTJB_REC (I).QXLX
                   AND TJRQ = TB_EAST_SNTJB_REC (I).TJRQ
                   AND BZ = TB_EAST_SNTJB_REC (I).BZ
                   AND CJRQ = TB_EAST_SNTJB_REC (I).CJRQ; --(NBJGH, TJKMBH, QXLX, TJRQ, BZ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_SNTJB_TMP (JRJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               TJKMBH,
                                               TJKMMC,
                                               TJKMJE,
                                               QXLX,
                                               TJRQ,
                                               BZ,
                                               DQMC,
                                               XZQHDM,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_SNTJB_REC (I).JRJGDM,
                         TB_EAST_SNTJB_REC (I).JRXKZH,
                         TB_EAST_SNTJB_REC (I).NBJGH,
                         TB_EAST_SNTJB_REC (I).TJKMBH,
                         TB_EAST_SNTJB_REC (I).TJKMMC,
                         TB_EAST_SNTJB_REC (I).TJKMJE,
                         TB_EAST_SNTJB_REC (I).QXLX,
                         TB_EAST_SNTJB_REC (I).TJRQ,
                         TB_EAST_SNTJB_REC (I).BZ,
                         TB_EAST_SNTJB_REC (I).DQMC,
                         TB_EAST_SNTJB_REC (I).XZQHDM,
                         TB_EAST_SNTJB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------EAST_SNTJBMXJL---内部分户账明细记录-END------------------


   -------------------------EAST_SXXX---授信信息---START--44------------------
   ELSIF P_TBNAME = 'EAST_SXXX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_SXXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_SXXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_SXXX_TMP
          WHERE     SXXYH = TB_EAST_SXXX_REC (I).SXXYH
                AND CJRQ = TB_EAST_SXXX_REC (I).CJRQ;          --(SXXYH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_SXXX_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     SXXYH = TB_EAST_SXXX_REC (I).SXXYH
                   AND CJRQ = TB_EAST_SXXX_REC (I).CJRQ;       --(SXXYH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_SXXX_TMP (SXXYH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              FSRQ,
                                              KHMC,
                                              SXZL,
                                              SXXYMC,
                                              EDJE,
                                              BZ,
                                              SXRQ,
                                              SXZT,
                                              SXKSRQ,
                                              SXDQRQ,
                                              SCSXRQ,
                                              JCDYJ,
                                              ZZSPR,
                                              SFXHED,
                                              SFLSED,
                                              SXYGH,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_SXXX_REC (I).SXXYH,
                         TB_EAST_SXXX_REC (I).KHTYBH,
                         TB_EAST_SXXX_REC (I).YXJGDM,
                         TB_EAST_SXXX_REC (I).JRXKZH,
                         TB_EAST_SXXX_REC (I).NBJGH,
                         TB_EAST_SXXX_REC (I).FSRQ,
                         TB_EAST_SXXX_REC (I).KHMC,
                         TB_EAST_SXXX_REC (I).SXZL,
                         TB_EAST_SXXX_REC (I).SXXYMC,
                         TB_EAST_SXXX_REC (I).EDJE,
                         TB_EAST_SXXX_REC (I).BZ,
                         TB_EAST_SXXX_REC (I).SXRQ,
                         TB_EAST_SXXX_REC (I).SXZT,
                         TB_EAST_SXXX_REC (I).SXKSRQ,
                         TB_EAST_SXXX_REC (I).SXDQRQ,
                         TB_EAST_SXXX_REC (I).SCSXRQ,
                         TB_EAST_SXXX_REC (I).JCDYJ,
                         TB_EAST_SXXX_REC (I).ZZSPR,
                         TB_EAST_SXXX_REC (I).SFXHED,
                         TB_EAST_SXXX_REC (I).SFLSED,
                         TB_EAST_SXXX_REC (I).SXYGH,
                         TB_EAST_SXXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------EAST_SXXX---授信信息-END-------------------

   --------------------------EAST_WTDK---委托贷款---START---45-----------------
   ELSIF P_TBNAME = 'EAST_WTDK'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_WTDK_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_WTDK_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_WTDK_TMP
          WHERE     XDJJH = TB_EAST_WTDK_REC (I).XDJJH
                AND CJRQ = TB_EAST_WTDK_REC (I).CJRQ;          --(XDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_WTDK_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     XDJJH = TB_EAST_WTDK_REC (I).XDJJH
                   AND CJRQ = TB_EAST_WTDK_REC (I).CJRQ;       --(XDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_WTDK_TMP (XDJJH,
                                              XDHTH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              WTRKHTYBH,
                                              WTRKHMC,
                                              SYRMC,
                                              WTJJKHXH,
                                              WTJJKHXMC,
                                              WTJJZH,
                                              WTZHLX,
                                              WTJE,
                                              SJWTDKJE,
                                              WTDKYT,
                                              SFSX,
                                              SXFFS,
                                              SXFJE,
                                              XYQSRQ,
                                              XYDQRQ,
                                              JBRXM,
                                              KHJLGH,
                                              JBJGMC,
                                              XYZT,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_WTDK_REC (I).XDJJH,
                         TB_EAST_WTDK_REC (I).XDHTH,
                         TB_EAST_WTDK_REC (I).KHTYBH,
                         TB_EAST_WTDK_REC (I).YXJGDM,
                         TB_EAST_WTDK_REC (I).JRXKZH,
                         TB_EAST_WTDK_REC (I).NBJGH,
                         TB_EAST_WTDK_REC (I).WTRKHTYBH,
                         TB_EAST_WTDK_REC (I).WTRKHMC,
                         TB_EAST_WTDK_REC (I).SYRMC,
                         TB_EAST_WTDK_REC (I).WTJJKHXH,
                         TB_EAST_WTDK_REC (I).WTJJKHXMC,
                         TB_EAST_WTDK_REC (I).WTJJZH,
                         TB_EAST_WTDK_REC (I).WTZHLX,
                         TB_EAST_WTDK_REC (I).WTJE,
                         TB_EAST_WTDK_REC (I).SJWTDKJE,
                         TB_EAST_WTDK_REC (I).WTDKYT,
                         TB_EAST_WTDK_REC (I).SFSX,
                         TB_EAST_WTDK_REC (I).SXFFS,
                         TB_EAST_WTDK_REC (I).SXFJE,
                         TB_EAST_WTDK_REC (I).XYQSRQ,
                         TB_EAST_WTDK_REC (I).XYDQRQ,
                         TB_EAST_WTDK_REC (I).JBRXM,
                         TB_EAST_WTDK_REC (I).KHJLGH,
                         TB_EAST_WTDK_REC (I).JBJGMC,
                         TB_EAST_WTDK_REC (I).XYZT,
                         TB_EAST_WTDK_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -----------------EAST_WTDK---委托贷款-END-------------------

   --------------------------EAST_XDHTB---信贷合同表---START---46-----------------
   ELSIF P_TBNAME = 'EAST_XDHTB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XDHTB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XDHTB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XDHTB_TMP
          WHERE     XDHTH = TB_EAST_XDHTB_REC (I).XDHTH
                AND CJRQ = TB_EAST_XDHTB_REC (I).CJRQ;         --(XDHTH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XDHTB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     XDHTH = TB_EAST_XDHTB_REC (I).XDHTH
                   AND CJRQ = TB_EAST_XDHTB_REC (I).CJRQ;     -- (XDHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XDHTB_TMP (XDHTH,
                                               ZHTH,
                                               KHTYBH,
                                               YXJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               KHMC,
                                               CPMC,
                                               DKXGZL,
                                               XDYWZL,
                                               BZ,
                                               JE,
                                               HTYDRQ,
                                               HTDQRQ,
                                               LLLX,
                                               JZLL,
                                               LLFD,
                                               ZYDBFS,
                                               GHJLGH,
                                               DKQX,
                                               FKFS,
                                               ZJLY,
                                               DKYT,
                                               DKTXDQ,
                                               DKTXXY,
                                               SFGJXZXY,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_XDHTB_REC (I).XDHTH,
                         TB_EAST_XDHTB_REC (I).ZHTH,
                         TB_EAST_XDHTB_REC (I).KHTYBH,
                         TB_EAST_XDHTB_REC (I).YXJGDM,
                         TB_EAST_XDHTB_REC (I).JRXKZH,
                         TB_EAST_XDHTB_REC (I).NBJGH,
                         TB_EAST_XDHTB_REC (I).KHMC,
                         TB_EAST_XDHTB_REC (I).CPMC,
                         TB_EAST_XDHTB_REC (I).DKXGZL,
                         TB_EAST_XDHTB_REC (I).XDYWZL,
                         TB_EAST_XDHTB_REC (I).BZ,
                         TB_EAST_XDHTB_REC (I).JE,
                         TB_EAST_XDHTB_REC (I).HTYDRQ,
                         TB_EAST_XDHTB_REC (I).HTDQRQ,
                         TB_EAST_XDHTB_REC (I).LLLX,
                         TB_EAST_XDHTB_REC (I).JZLL,
                         TB_EAST_XDHTB_REC (I).LLFD,
                         TB_EAST_XDHTB_REC (I).ZYDBFS,
                         TB_EAST_XDHTB_REC (I).GHJLGH,
                         TB_EAST_XDHTB_REC (I).DKQX,
                         TB_EAST_XDHTB_REC (I).FKFS,
                         TB_EAST_XDHTB_REC (I).ZJLY,
                         TB_EAST_XDHTB_REC (I).DKYT,
                         TB_EAST_XDHTB_REC (I).DKTXDQ,
                         TB_EAST_XDHTB_REC (I).DKTXXY,
                         TB_EAST_XDHTB_REC (I).SFGJXZXY,
                         TB_EAST_XDHTB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -----------------EAST_XDHTB---信贷合同表-END-------------------


   -------------------------- EAST_XDYWDBHT---信贷业务担保合同---START---47-----------------
   ELSIF P_TBNAME = 'EAST_XDYWDBHT'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XDYWDBHT_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XDYWDBHT_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XDYWDBHT_TMP
          WHERE     DBHTH = TB_EAST_XDYWDBHT_REC (I).DBHTH
                AND ZJHM = TB_EAST_XDYWDBHT_REC (I).ZJHM
                AND CJRQ = TB_EAST_XDYWDBHT_REC (I).CJRQ; --DBHTH, ZJHM, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XDYWDBHT_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     DBHTH = TB_EAST_XDYWDBHT_REC (I).DBHTH
                   AND ZJHM = TB_EAST_XDYWDBHT_REC (I).ZJHM
                   AND CJRQ = TB_EAST_XDYWDBHT_REC (I).CJRQ;  -- (XDHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XDYWDBHT_TMP (DBHTH,
                                                  JRXKZH,
                                                  YXJGDM,
                                                  NBJGH,
                                                  DBLX,
                                                  DBHTLX,
                                                  BZRLB,
                                                  BZRMC,
                                                  ZJLB,
                                                  ZJHM,
                                                  BZRJZC,
                                                  DBQSRQ,
                                                  DBDQRQ,
                                                  DBHTZT,
                                                  DBHTQDRQ,
                                                  DBHTSXRQ,
                                                  DBHTDQRQ,
                                                  DBBZ,
                                                  DBZJE,
                                                  DBWPXH,
                                                  JLYGH,
                                                  CJRQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_XDYWDBHT_REC (I).DBHTH,
                         TB_EAST_XDYWDBHT_REC (I).JRXKZH,
                         TB_EAST_XDYWDBHT_REC (I).YXJGDM,
                         TB_EAST_XDYWDBHT_REC (I).NBJGH,
                         TB_EAST_XDYWDBHT_REC (I).DBLX,
                         TB_EAST_XDYWDBHT_REC (I).DBHTLX,
                         TB_EAST_XDYWDBHT_REC (I).BZRLB,
                         TB_EAST_XDYWDBHT_REC (I).BZRMC,
                         TB_EAST_XDYWDBHT_REC (I).ZJLB,
                         TB_EAST_XDYWDBHT_REC (I).ZJHM,
                         TB_EAST_XDYWDBHT_REC (I).BZRJZC,
                         TB_EAST_XDYWDBHT_REC (I).DBQSRQ,
                         TB_EAST_XDYWDBHT_REC (I).DBDQRQ,
                         TB_EAST_XDYWDBHT_REC (I).DBHTZT,
                         TB_EAST_XDYWDBHT_REC (I).DBHTQDRQ,
                         TB_EAST_XDYWDBHT_REC (I).DBHTSXRQ,
                         TB_EAST_XDYWDBHT_REC (I).DBHTDQRQ,
                         TB_EAST_XDYWDBHT_REC (I).DBBZ,
                         TB_EAST_XDYWDBHT_REC (I).DBZJE,
                         TB_EAST_XDYWDBHT_REC (I).DBWPXH,
                         TB_EAST_XDYWDBHT_REC (I).JLYGH,
                         TB_EAST_XDYWDBHT_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------- EAST_XDYWDBHT---信贷业务担保合同-END-------------------

   ----------------------------- EAST_XDYWZHDYW---信贷业务质或抵押物---START---48-----------------
   ELSIF P_TBNAME = 'EAST_XDYWZHDYW'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XDYWZHDYW_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XDYWZHDYW_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XDYWZHDYW_TMP
          WHERE     ZHDYWBH = TB_EAST_XDYWZHDYW_REC (I).ZHDYWBH
                AND CJRQ = TB_EAST_XDYWZHDYW_REC (I).CJRQ;   --(ZHDYWBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XDYWZHDYW_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     ZHDYWBH = TB_EAST_XDYWZHDYW_REC (I).ZHDYWBH
                   AND CJRQ = TB_EAST_XDYWZHDYW_REC (I).CJRQ; -- (XDHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XDYWZHDYW_TMP (ZHDYWBH,
                                                   DBHTH,
                                                   KHTYBH,
                                                   YXJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   ZHDYWMC,
                                                   ZHDYWLX,
                                                   ZHDYWZMJZ,
                                                   BZ,
                                                   YXRDJZ,
                                                   PGJZ,
                                                   PGRQ,
                                                   PGJGMC,
                                                   ZHDYL,
                                                   DYWSYQRMC,
                                                   YDYJZ,
                                                   DJRQ,
                                                   SWSQRQ,
                                                   DJJG,
                                                   CZJG,
                                                   DBQSRQ,
                                                   DBDQRQ,
                                                   ZYPZZH,
                                                   ZYPZLX,
                                                   ZYPZHM,
                                                   ZYPZJE,
                                                   ZYPZQFJG,
                                                   ZYPZKLRQ,
                                                   BXDH,
                                                   HBRQ,
                                                   HBRYXM,
                                                   HBREXM,
                                                   QZDJHM,
                                                   QZMC,
                                                   QZYXDQRQ,
                                                   DJYXZZRQ,
                                                   SFNRBWHS,
                                                   BWHSKSRQ,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_XDYWZHDYW_REC (I).ZHDYWBH,
                         TB_EAST_XDYWZHDYW_REC (I).DBHTH,
                         TB_EAST_XDYWZHDYW_REC (I).KHTYBH,
                         TB_EAST_XDYWZHDYW_REC (I).YXJGDM,
                         TB_EAST_XDYWZHDYW_REC (I).JRXKZH,
                         TB_EAST_XDYWZHDYW_REC (I).NBJGH,
                         TB_EAST_XDYWZHDYW_REC (I).ZHDYWMC,
                         TB_EAST_XDYWZHDYW_REC (I).ZHDYWLX,
                         TB_EAST_XDYWZHDYW_REC (I).ZHDYWZMJZ,
                         TB_EAST_XDYWZHDYW_REC (I).BZ,
                         TB_EAST_XDYWZHDYW_REC (I).YXRDJZ,
                         TB_EAST_XDYWZHDYW_REC (I).PGJZ,
                         TB_EAST_XDYWZHDYW_REC (I).PGRQ,
                         TB_EAST_XDYWZHDYW_REC (I).PGJGMC,
                         TB_EAST_XDYWZHDYW_REC (I).ZHDYL,
                         TB_EAST_XDYWZHDYW_REC (I).DYWSYQRMC,
                         TB_EAST_XDYWZHDYW_REC (I).YDYJZ,
                         TB_EAST_XDYWZHDYW_REC (I).DJRQ,
                         TB_EAST_XDYWZHDYW_REC (I).SWSQRQ,
                         TB_EAST_XDYWZHDYW_REC (I).DJJG,
                         TB_EAST_XDYWZHDYW_REC (I).CZJG,
                         TB_EAST_XDYWZHDYW_REC (I).DBQSRQ,
                         TB_EAST_XDYWZHDYW_REC (I).DBDQRQ,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZZH,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZLX,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZHM,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZJE,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZQFJG,
                         TB_EAST_XDYWZHDYW_REC (I).ZYPZKLRQ,
                         TB_EAST_XDYWZHDYW_REC (I).BXDH,
                         TB_EAST_XDYWZHDYW_REC (I).HBRQ,
                         TB_EAST_XDYWZHDYW_REC (I).HBRYXM,
                         TB_EAST_XDYWZHDYW_REC (I).HBREXM,
                         TB_EAST_XDYWZHDYW_REC (I).QZDJHM,
                         TB_EAST_XDYWZHDYW_REC (I).QZMC,
                         TB_EAST_XDYWZHDYW_REC (I).QZYXDQRQ,
                         TB_EAST_XDYWZHDYW_REC (I).DJYXZZRQ,
                         TB_EAST_XDYWZHDYW_REC (I).SFNRBWHS,
                         TB_EAST_XDYWZHDYW_REC (I).BWHSKSRQ,
                         TB_EAST_XDYWZHDYW_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -------------------- EAST_XDYWZHDYW---信贷业务质或抵押物-END-------------------


   ------------------------------ EAST_XDZCZR---信贷资产转让---START----49----------------
   ELSIF P_TBNAME = 'EAST_XDZCZR'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XDZCZR_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XDZCZR_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XDZCZR_TMP
          WHERE     ZRHTH = TB_EAST_XDZCZR_REC (I).ZRHTH
                AND CJRQ = TB_EAST_XDZCZR_REC (I).CJRQ;        --(ZRHTH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XDZCZR_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     ZRHTH = TB_EAST_XDZCZR_REC (I).ZRHTH
                   AND CJRQ = TB_EAST_XDZCZR_REC (I).CJRQ;    -- (ZRHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XDZCZR_TMP (ZRHTH,
                                                YXJGDM,
                                                JRXKZH,
                                                NBJGH,
                                                MXKMBH,
                                                MXKMMC,
                                                JYDSBH,
                                                JYDSMC,
                                                XDJYLX,
                                                JYZCLX,
                                                BZ,
                                                ZRDKBJZE,
                                                ZRDKLXZE,
                                                ZRSXF,
                                                ZRZJ,
                                                HGLL,
                                                ZRJGRQ,
                                                HGJZRQ,
                                                ZRHTQSRQ,
                                                ZRHTDQRQ,
                                                JYDSZZH,
                                                JYDSZZZHHM,
                                                JYDSXH,
                                                CJRQ,
                                                ERRMSG)
                 VALUES (TB_EAST_XDZCZR_REC (I).ZRHTH,
                         TB_EAST_XDZCZR_REC (I).YXJGDM,
                         TB_EAST_XDZCZR_REC (I).JRXKZH,
                         TB_EAST_XDZCZR_REC (I).NBJGH,
                         TB_EAST_XDZCZR_REC (I).MXKMBH,
                         TB_EAST_XDZCZR_REC (I).MXKMMC,
                         TB_EAST_XDZCZR_REC (I).JYDSBH,
                         TB_EAST_XDZCZR_REC (I).JYDSMC,
                         TB_EAST_XDZCZR_REC (I).XDJYLX,
                         TB_EAST_XDZCZR_REC (I).JYZCLX,
                         TB_EAST_XDZCZR_REC (I).BZ,
                         TB_EAST_XDZCZR_REC (I).ZRDKBJZE,
                         TB_EAST_XDZCZR_REC (I).ZRDKLXZE,
                         TB_EAST_XDZCZR_REC (I).ZRSXF,
                         TB_EAST_XDZCZR_REC (I).ZRZJ,
                         TB_EAST_XDZCZR_REC (I).HGLL,
                         TB_EAST_XDZCZR_REC (I).ZRJGRQ,
                         TB_EAST_XDZCZR_REC (I).HGJZRQ,
                         TB_EAST_XDZCZR_REC (I).ZRHTQSRQ,
                         TB_EAST_XDZCZR_REC (I).ZRHTDQRQ,
                         TB_EAST_XDZCZR_REC (I).JYDSZZH,
                         TB_EAST_XDZCZR_REC (I).JYDSZZZHHM,
                         TB_EAST_XDZCZR_REC (I).JYDSXH,
                         TB_EAST_XDZCZR_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------------------- EAST_XDZCZR---信贷资产转让-END-------------------

   -----------------------------EAST_XMDKXXB---项目贷款信息表---START---50-----------------
   ELSIF P_TBNAME = 'EAST_XMDKXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XMDKXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XMDKXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XMDKXXB_TMP
          WHERE     XDHTH = TB_EAST_XMDKXXB_REC (I).XDHTH
                AND CJRQ = TB_EAST_XMDKXXB_REC (I).CJRQ;       --(XDHTH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XMDKXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     XDHTH = TB_EAST_XMDKXXB_REC (I).XDHTH
                   AND CJRQ = TB_EAST_XMDKXXB_REC (I).CJRQ;   -- (XDHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XMDKXXB_TMP (XDHTH,
                                                 KHTYBH,
                                                 YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 JKRMC,
                                                 XMMC,
                                                 XMLX,
                                                 SFYT,
                                                 XMZTZ,
                                                 ZBJ,
                                                 XMDKJE,
                                                 XMDKQX,
                                                 PWWH,
                                                 LXPW,
                                                 GHXKZBH,
                                                 JSYDXKZBH,
                                                 HPXKZBH,
                                                 SGXKZBH,
                                                 QTXKZ,
                                                 QTXKZBH,
                                                 KGRQ,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_XMDKXXB_REC (I).XDHTH,
                         TB_EAST_XMDKXXB_REC (I).KHTYBH,
                         TB_EAST_XMDKXXB_REC (I).YXJGDM,
                         TB_EAST_XMDKXXB_REC (I).JRXKZH,
                         TB_EAST_XMDKXXB_REC (I).NBJGH,
                         TB_EAST_XMDKXXB_REC (I).JKRMC,
                         TB_EAST_XMDKXXB_REC (I).XMMC,
                         TB_EAST_XMDKXXB_REC (I).XMLX,
                         TB_EAST_XMDKXXB_REC (I).SFYT,
                         TB_EAST_XMDKXXB_REC (I).XMZTZ,
                         TB_EAST_XMDKXXB_REC (I).ZBJ,
                         TB_EAST_XMDKXXB_REC (I).XMDKJE,
                         TB_EAST_XMDKXXB_REC (I).XMDKQX,
                         TB_EAST_XMDKXXB_REC (I).PWWH,
                         TB_EAST_XMDKXXB_REC (I).LXPW,
                         TB_EAST_XMDKXXB_REC (I).GHXKZBH,
                         TB_EAST_XMDKXXB_REC (I).JSYDXKZBH,
                         TB_EAST_XMDKXXB_REC (I).HPXKZBH,
                         TB_EAST_XMDKXXB_REC (I).SGXKZBH,
                         TB_EAST_XMDKXXB_REC (I).QTXKZ,
                         TB_EAST_XMDKXXB_REC (I).QTXKZBH,
                         TB_EAST_XMDKXXB_REC (I).KGRQ,
                         TB_EAST_XMDKXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------------------EAST_XMDKXXB---项目贷款信息表-END-------------------

   ------------------------------ EAST_XYKXX---信用卡信息---START-----51---------------
   ELSIF P_TBNAME = 'EAST_XYKXX'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XYKXX_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XYKXX_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XYKXX_TMP
          WHERE     KH = TB_EAST_XYKXX_REC (I).KH
                AND CJRQ = TB_EAST_XYKXX_REC (I).CJRQ;            --(KH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XYKXX_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     KH = TB_EAST_XYKXX_REC (I).KH
                   AND CJRQ = TB_EAST_XYKXX_REC (I).CJRQ;        -- (KH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XYKXX_TMP (KH,
                                               XYKZH,
                                               KHTYBH,
                                               YXJGDM,
                                               JRXKZH,
                                               NBJGH,
                                               ZJLB,
                                               ZJHM,
                                               KPMC,
                                               KPJB,
                                               KPZT,
                                               KZZMC,
                                               YGKBZ,
                                               FSKBZ,
                                               ZKH,
                                               NFBZ,
                                               BBXYED,
                                               WBXYED,
                                               WBBZ,
                                               BBXJZQED,
                                               WBXJZQED,
                                               ZKRQ,
                                               SLRQ,
                                               SLYGH,
                                               KKRQ,
                                               KKYGH,
                                               XKRQ,
                                               XKYGH,
                                               ZHZT,
                                               BBQXJE,
                                               BBXFJE,
                                               BBTZJE,
                                               WBXFJE,
                                               WBQXJE,
                                               WBTZJE,
                                               BBYE,
                                               WBYE,
                                               DJYE,
                                               BLJE,
                                               BNLJXFJE,
                                               LSED,
                                               DQQFJE,
                                               DBLX,
                                               DBSM,
                                               DKWJFL,
                                               DQTZLX,
                                               ZHDHJYRQ,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_XYKXX_REC (I).KH,
                         TB_EAST_XYKXX_REC (I).XYKZH,
                         TB_EAST_XYKXX_REC (I).KHTYBH,
                         TB_EAST_XYKXX_REC (I).YXJGDM,
                         TB_EAST_XYKXX_REC (I).JRXKZH,
                         TB_EAST_XYKXX_REC (I).NBJGH,
                         TB_EAST_XYKXX_REC (I).ZJLB,
                         TB_EAST_XYKXX_REC (I).ZJHM,
                         TB_EAST_XYKXX_REC (I).KPMC,
                         TB_EAST_XYKXX_REC (I).KPJB,
                         TB_EAST_XYKXX_REC (I).KPZT,
                         TB_EAST_XYKXX_REC (I).KZZMC,
                         TB_EAST_XYKXX_REC (I).YGKBZ,
                         TB_EAST_XYKXX_REC (I).FSKBZ,
                         TB_EAST_XYKXX_REC (I).ZKH,
                         TB_EAST_XYKXX_REC (I).NFBZ,
                         TB_EAST_XYKXX_REC (I).BBXYED,
                         TB_EAST_XYKXX_REC (I).WBXYED,
                         TB_EAST_XYKXX_REC (I).WBBZ,
                         TB_EAST_XYKXX_REC (I).BBXJZQED,
                         TB_EAST_XYKXX_REC (I).WBXJZQED,
                         TB_EAST_XYKXX_REC (I).ZKRQ,
                         TB_EAST_XYKXX_REC (I).SLRQ,
                         TB_EAST_XYKXX_REC (I).SLYGH,
                         TB_EAST_XYKXX_REC (I).KKRQ,
                         TB_EAST_XYKXX_REC (I).KKYGH,
                         TB_EAST_XYKXX_REC (I).XKRQ,
                         TB_EAST_XYKXX_REC (I).XKYGH,
                         TB_EAST_XYKXX_REC (I).ZHZT,
                         TB_EAST_XYKXX_REC (I).BBQXJE,
                         TB_EAST_XYKXX_REC (I).BBXFJE,
                         TB_EAST_XYKXX_REC (I).BBTZJE,
                         TB_EAST_XYKXX_REC (I).WBXFJE,
                         TB_EAST_XYKXX_REC (I).WBQXJE,
                         TB_EAST_XYKXX_REC (I).WBTZJE,
                         TB_EAST_XYKXX_REC (I).BBYE,
                         TB_EAST_XYKXX_REC (I).WBYE,
                         TB_EAST_XYKXX_REC (I).DJYE,
                         TB_EAST_XYKXX_REC (I).BLJE,
                         TB_EAST_XYKXX_REC (I).BNLJXFJE,
                         TB_EAST_XYKXX_REC (I).LSED,
                         TB_EAST_XYKXX_REC (I).DQQFJE,
                         TB_EAST_XYKXX_REC (I).DBLX,
                         TB_EAST_XYKXX_REC (I).DBSM,
                         TB_EAST_XYKXX_REC (I).DKWJFL,
                         TB_EAST_XYKXX_REC (I).DQTZLX,
                         TB_EAST_XYKXX_REC (I).ZHDHJYRQ,
                         TB_EAST_XYKXX_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------------------- EAST_XYKXX---信用卡信息-END-------------------

   ------------------------------EAST_XYKZHJYMXB---信用卡账户交易明细记录---START---52-----------------
   ELSIF P_TBNAME = 'EAST_XYKZHJYMXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_XYKZHJYMXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_XYKZHJYMXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_XYKZHJYMXB_TMP
          WHERE     JYJZRQ = TB_EAST_XYKZHJYMXB_REC (I).JYJZRQ
                AND HXJYLSH = TB_EAST_XYKZHJYMXB_REC (I).HXJYLSH
                AND ZJYLSH = TB_EAST_XYKZHJYMXB_REC (I).ZJYLSH
                AND BCXH = TB_EAST_XYKZHJYMXB_REC (I).BCXH
                AND CJRQ = TB_EAST_XYKZHJYMXB_REC (I).CJRQ; --(JYJZRQ, HXJYLSH, ZJYLSH, BCXH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_XYKZHJYMXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     JYJZRQ = TB_EAST_XYKZHJYMXB_REC (I).JYJZRQ
                   AND HXJYLSH = TB_EAST_XYKZHJYMXB_REC (I).HXJYLSH
                   AND ZJYLSH = TB_EAST_XYKZHJYMXB_REC (I).ZJYLSH
                   AND BCXH = TB_EAST_XYKZHJYMXB_REC (I).BCXH
                   AND CJRQ = TB_EAST_XYKZHJYMXB_REC (I).CJRQ; --(JYJZRQ, HXJYLSH, ZJYLSH, BCXH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_XYKZHJYMXB_TMP (KH,
                                                    XYKZH,
                                                    YXJGDM,
                                                    NBJGH,
                                                    JRXKZH,
                                                    MXKMBH,
                                                    MXKMMC,
                                                    BZ,
                                                    JYJZRQ,
                                                    HXJYLSH,
                                                    ZJYLSH,
                                                    BCXH,
                                                    KPJYLX,
                                                    CHLB,
                                                    XZBZ,
                                                    JYPZH,
                                                    JYJDBZ,
                                                    JYJE,
                                                    KHSXFJE,
                                                    QKGHCX,
                                                    JYQXRQ,
                                                    JYFSRQ,
                                                    JYZDRQ,
                                                    DFZH,
                                                    FQFKBZ,
                                                    JYQD,
                                                    JYSJ,
                                                    JYGYH,
                                                    JYJGH,
                                                    GZZXZ,
                                                    GZZBH,
                                                    ZY,
                                                    BZH,
                                                    CJRQ,
                                                    ERRMSG)
                 VALUES (TB_EAST_XYKZHJYMXB_REC (I).KH,
                         TB_EAST_XYKZHJYMXB_REC (I).XYKZH,
                         TB_EAST_XYKZHJYMXB_REC (I).YXJGDM,
                         TB_EAST_XYKZHJYMXB_REC (I).NBJGH,
                         TB_EAST_XYKZHJYMXB_REC (I).JRXKZH,
                         TB_EAST_XYKZHJYMXB_REC (I).MXKMBH,
                         TB_EAST_XYKZHJYMXB_REC (I).MXKMMC,
                         TB_EAST_XYKZHJYMXB_REC (I).BZ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYJZRQ,
                         TB_EAST_XYKZHJYMXB_REC (I).HXJYLSH,
                         TB_EAST_XYKZHJYMXB_REC (I).ZJYLSH,
                         TB_EAST_XYKZHJYMXB_REC (I).BCXH,
                         TB_EAST_XYKZHJYMXB_REC (I).KPJYLX,
                         TB_EAST_XYKZHJYMXB_REC (I).CHLB,
                         TB_EAST_XYKZHJYMXB_REC (I).XZBZ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYPZH,
                         TB_EAST_XYKZHJYMXB_REC (I).JYJDBZ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYJE,
                         TB_EAST_XYKZHJYMXB_REC (I).KHSXFJE,
                         TB_EAST_XYKZHJYMXB_REC (I).QKGHCX,
                         TB_EAST_XYKZHJYMXB_REC (I).JYQXRQ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYFSRQ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYZDRQ,
                         TB_EAST_XYKZHJYMXB_REC (I).DFZH,
                         TB_EAST_XYKZHJYMXB_REC (I).FQFKBZ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYQD,
                         TB_EAST_XYKZHJYMXB_REC (I).JYSJ,
                         TB_EAST_XYKZHJYMXB_REC (I).JYGYH,
                         TB_EAST_XYKZHJYMXB_REC (I).JYJGH,
                         TB_EAST_XYKZHJYMXB_REC (I).GZZXZ,
                         TB_EAST_XYKZHJYMXB_REC (I).GZZBH,
                         TB_EAST_XYKZHJYMXB_REC (I).ZY,
                         TB_EAST_XYKZHJYMXB_REC (I).BZH,
                         TB_EAST_XYKZHJYMXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------------EAST_XYKZHJYMXB---信用卡账户交易明细记录-END-------------------

   ------------------------------EAST_YTDK---银团贷款---START------53--------------
   ELSIF P_TBNAME = 'EAST_YTDK'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_YTDK_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_YTDK_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_YTDK_TMP
          WHERE     XDHTH = TB_EAST_YTDK_REC (I).XDHTH
                AND CJRQ = TB_EAST_YTDK_REC (I).CJRQ;          --(XDHTH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_YTDK_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     XDHTH = TB_EAST_YTDK_REC (I).XDHTH
                   AND CJRQ = TB_EAST_YTDK_REC (I).CJRQ;       --(XDHTH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_YTDK_TMP (XDHTH,
                                              KHTYBH,
                                              YXJGDM,
                                              JRXKZH,
                                              NBJGH,
                                              XYLX,
                                              ZBXXH,
                                              CDXXH,
                                              DLXXH,
                                              ZBXXM,
                                              CDXXM,
                                              DLXXM,
                                              DLCDBZ,
                                              JKRMC,
                                              SQDKZE,
                                              CDDKJE,
                                              SJCDDKJE,
                                              YFFDKJE,
                                              YFFCDDKJE,
                                              CDSYDKJE,
                                              JLXYXJGDM,
                                              XYQSRQ,
                                              XYZZRQ,
                                              XYZT,
                                              FHGY,
                                              CJRQ,
                                              ERRMSG)
                 VALUES (TB_EAST_YTDK_REC (I).XDHTH,
                         TB_EAST_YTDK_REC (I).KHTYBH,
                         TB_EAST_YTDK_REC (I).YXJGDM,
                         TB_EAST_YTDK_REC (I).JRXKZH,
                         TB_EAST_YTDK_REC (I).NBJGH,
                         TB_EAST_YTDK_REC (I).XYLX,
                         TB_EAST_YTDK_REC (I).ZBXXH,
                         TB_EAST_YTDK_REC (I).CDXXH,
                         TB_EAST_YTDK_REC (I).DLXXH,
                         TB_EAST_YTDK_REC (I).ZBXXM,
                         TB_EAST_YTDK_REC (I).CDXXM,
                         TB_EAST_YTDK_REC (I).DLXXM,
                         TB_EAST_YTDK_REC (I).DLCDBZ,
                         TB_EAST_YTDK_REC (I).JKRMC,
                         TB_EAST_YTDK_REC (I).SQDKZE,
                         TB_EAST_YTDK_REC (I).CDDKJE,
                         TB_EAST_YTDK_REC (I).SJCDDKJE,
                         TB_EAST_YTDK_REC (I).YFFDKJE,
                         TB_EAST_YTDK_REC (I).YFFCDDKJE,
                         TB_EAST_YTDK_REC (I).CDSYDKJE,
                         TB_EAST_YTDK_REC (I).JLXYXJGDM,
                         TB_EAST_YTDK_REC (I).XYQSRQ,
                         TB_EAST_YTDK_REC (I).XYZZRQ,
                         TB_EAST_YTDK_REC (I).XYZT,
                         TB_EAST_YTDK_REC (I).FHGY,
                         TB_EAST_YTDK_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------------EAST_YTDK---银团贷款-END-------------------

   ------------------------------EAST_ZCFZKMTJB---资产负债科目统计表---START---54-----------------
   ELSIF P_TBNAME = 'EAST_ZCFZKMTJB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_ZCFZKMTJB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_ZCFZKMTJB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_ZCFZKMTJB_TMP
          WHERE     NBJGH = TB_EAST_ZCFZKMTJB_REC (I).NBJGH
                AND TJKMBH = TB_EAST_ZCFZKMTJB_REC (I).TJKMBH
                AND QXLX = TB_EAST_ZCFZKMTJB_REC (I).QXLX
                AND TJRQ = TB_EAST_ZCFZKMTJB_REC (I).TJRQ
                AND BZ = TB_EAST_ZCFZKMTJB_REC (I).BZ
                AND CJRQ = TB_EAST_ZCFZKMTJB_REC (I).CJRQ; --(NBJGH, TJKMBH, QXLX, TJRQ, BZ, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_ZCFZKMTJB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     NBJGH = TB_EAST_ZCFZKMTJB_REC (I).NBJGH
                   AND TJKMBH = TB_EAST_ZCFZKMTJB_REC (I).TJKMBH
                   AND QXLX = TB_EAST_ZCFZKMTJB_REC (I).QXLX
                   AND TJRQ = TB_EAST_ZCFZKMTJB_REC (I).TJRQ
                   AND BZ = TB_EAST_ZCFZKMTJB_REC (I).BZ
                   AND CJRQ = TB_EAST_ZCFZKMTJB_REC (I).CJRQ; --(NBJGH, TJKMBH, QXLX, TJRQ, BZ, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_ZCFZKMTJB_TMP (JRJGDM,
                                                   JRXKZH,
                                                   NBJGH,
                                                   TJKMBH,
                                                   TJKMMC,
                                                   TJKMJE,
                                                   QXLX,
                                                   TJRQ,
                                                   BZ,
                                                   DQMC,
                                                   XZQHDM,
                                                   CJRQ,
                                                   ERRMSG)
                 VALUES (TB_EAST_ZCFZKMTJB_REC (I).JRJGDM,
                         TB_EAST_ZCFZKMTJB_REC (I).JRXKZH,
                         TB_EAST_ZCFZKMTJB_REC (I).NBJGH,
                         TB_EAST_ZCFZKMTJB_REC (I).TJKMBH,
                         TB_EAST_ZCFZKMTJB_REC (I).TJKMMC,
                         TB_EAST_ZCFZKMTJB_REC (I).TJKMJE,
                         TB_EAST_ZCFZKMTJB_REC (I).QXLX,
                         TB_EAST_ZCFZKMTJB_REC (I).TJRQ,
                         TB_EAST_ZCFZKMTJB_REC (I).BZ,
                         TB_EAST_ZCFZKMTJB_REC (I).DQMC,
                         TB_EAST_ZCFZKMTJB_REC (I).XZQHDM,
                         TB_EAST_ZCFZKMTJB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------------EAST_ZCFZKMTJB---资产负债科目统计表-END-------------------

   -------------------------------EAST_ZCZRGXB---资产转让关系表---START-----55---------------
   ELSIF P_TBNAME = 'EAST_ZCZRGXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_ZCZRGXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_ZCZRGXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_ZCZRGXB_TMP
          WHERE     XDJJH = TB_EAST_ZCZRGXB_REC (I).XDJJH
                AND CJRQ = TB_EAST_ZCZRGXB_REC (I).CJRQ;       --(XDJJH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_ZCZRGXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     XDJJH = TB_EAST_ZCZRGXB_REC (I).XDJJH
                   AND CJRQ = TB_EAST_ZCZRGXB_REC (I).CJRQ;    --(XDJJH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_ZCZRGXB_TMP (ZRHTH,
                                                 YXJGDM,
                                                 XDJJH,
                                                 JRXKZH,
                                                 NBJGH,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_ZCZRGXB_REC (I).ZRHTH,
                         TB_EAST_ZCZRGXB_REC (I).YXJGDM,
                         TB_EAST_ZCZRGXB_REC (I).XDJJH,
                         TB_EAST_ZCZRGXB_REC (I).JRXKZH,
                         TB_EAST_ZCZRGXB_REC (I).NBJGH,
                         TB_EAST_ZCZRGXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ----------------------EAST_ZCZRGXB---资产转让关系表-END-------------------

   ---------------------------EAST_ZJJYXXB---资金交易信息表---START----56----------------
   ELSIF P_TBNAME = 'EAST_ZJJYXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_ZJJYXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_ZJJYXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_ZJJYXXB_TMP
          WHERE     JYBH = TB_EAST_ZJJYXXB_REC (I).JYBH
                AND JRGJBH = TB_EAST_ZJJYXXB_REC (I).JRGJBH
                AND CJRQ = TB_EAST_ZJJYXXB_REC (I).CJRQ; --(JYBH, JRGJBH, CJRQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_ZJJYXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     JYBH = TB_EAST_ZJJYXXB_REC (I).JYBH
                   AND JRGJBH = TB_EAST_ZJJYXXB_REC (I).JRGJBH
                   AND CJRQ = TB_EAST_ZJJYXXB_REC (I).CJRQ; --(JYBH, JRGJBH, CJRQ)
         ELSE
            INSERT INTO REPORT.EAST_ZJJYXXB_TMP (YXJGDM,
                                                 JRXKZH,
                                                 NBJGH,
                                                 MXKMBH,
                                                 YXJGMC,
                                                 MXKMMC,
                                                 JYBH,
                                                 LCCPDJBM,
                                                 JYLX,
                                                 JYZL,
                                                 JRGJBH,
                                                 JYZHLX,
                                                 HTH,
                                                 HTJE,
                                                 BZ,
                                                 JCZCKHMC,
                                                 JCZCSSHY,
                                                 JCZCSFWBHKH,
                                                 JCZCZXFS,
                                                 JCZCZXR,
                                                 JYGY,
                                                 SPR,
                                                 JYDSDM,
                                                 JYDSMC,
                                                 JYRQ,
                                                 QSRQ,
                                                 DQRQ,
                                                 MMBZ,
                                                 JYQBZ,
                                                 MRBZ,
                                                 MRJE,
                                                 MCBZ,
                                                 MCJE,
                                                 CJJG,
                                                 YWZT,
                                                 FHRQ,
                                                 QXRQ,
                                                 SJJGRQ,
                                                 QSBZ,
                                                 JFZH,
                                                 DFZH,
                                                 JFJE,
                                                 DFJE,
                                                 JFBZ,
                                                 DFBZ,
                                                 JFLL,
                                                 DFLL,
                                                 BZJJYBZ,
                                                 GLBZJZH,
                                                 GLYWBH,
                                                 WBGLXTMC,
                                                 CJRQ,
                                                 ERRMSG)
                 VALUES (TB_EAST_ZJJYXXB_REC (I).YXJGDM,
                         TB_EAST_ZJJYXXB_REC (I).JRXKZH,
                         TB_EAST_ZJJYXXB_REC (I).NBJGH,
                         TB_EAST_ZJJYXXB_REC (I).MXKMBH,
                         TB_EAST_ZJJYXXB_REC (I).YXJGMC,
                         TB_EAST_ZJJYXXB_REC (I).MXKMMC,
                         TB_EAST_ZJJYXXB_REC (I).JYBH,
                         TB_EAST_ZJJYXXB_REC (I).LCCPDJBM,
                         TB_EAST_ZJJYXXB_REC (I).JYLX,
                         TB_EAST_ZJJYXXB_REC (I).JYZL,
                         TB_EAST_ZJJYXXB_REC (I).JRGJBH,
                         TB_EAST_ZJJYXXB_REC (I).JYZHLX,
                         TB_EAST_ZJJYXXB_REC (I).HTH,
                         TB_EAST_ZJJYXXB_REC (I).HTJE,
                         TB_EAST_ZJJYXXB_REC (I).BZ,
                         TB_EAST_ZJJYXXB_REC (I).JCZCKHMC,
                         TB_EAST_ZJJYXXB_REC (I).JCZCSSHY,
                         TB_EAST_ZJJYXXB_REC (I).JCZCSFWBHKH,
                         TB_EAST_ZJJYXXB_REC (I).JCZCZXFS,
                         TB_EAST_ZJJYXXB_REC (I).JCZCZXR,
                         TB_EAST_ZJJYXXB_REC (I).JYGY,
                         TB_EAST_ZJJYXXB_REC (I).SPR,
                         TB_EAST_ZJJYXXB_REC (I).JYDSDM,
                         TB_EAST_ZJJYXXB_REC (I).JYDSMC,
                         TB_EAST_ZJJYXXB_REC (I).JYRQ,
                         TB_EAST_ZJJYXXB_REC (I).QSRQ,
                         TB_EAST_ZJJYXXB_REC (I).DQRQ,
                         TB_EAST_ZJJYXXB_REC (I).MMBZ,
                         TB_EAST_ZJJYXXB_REC (I).JYQBZ,
                         TB_EAST_ZJJYXXB_REC (I).MRBZ,
                         TB_EAST_ZJJYXXB_REC (I).MRJE,
                         TB_EAST_ZJJYXXB_REC (I).MCBZ,
                         TB_EAST_ZJJYXXB_REC (I).MCJE,
                         TB_EAST_ZJJYXXB_REC (I).CJJG,
                         TB_EAST_ZJJYXXB_REC (I).YWZT,
                         TB_EAST_ZJJYXXB_REC (I).FHRQ,
                         TB_EAST_ZJJYXXB_REC (I).QXRQ,
                         TB_EAST_ZJJYXXB_REC (I).SJJGRQ,
                         TB_EAST_ZJJYXXB_REC (I).QSBZ,
                         TB_EAST_ZJJYXXB_REC (I).JFZH,
                         TB_EAST_ZJJYXXB_REC (I).DFZH,
                         TB_EAST_ZJJYXXB_REC (I).JFJE,
                         TB_EAST_ZJJYXXB_REC (I).DFJE,
                         TB_EAST_ZJJYXXB_REC (I).JFBZ,
                         TB_EAST_ZJJYXXB_REC (I).DFBZ,
                         TB_EAST_ZJJYXXB_REC (I).JFLL,
                         TB_EAST_ZJJYXXB_REC (I).DFLL,
                         TB_EAST_ZJJYXXB_REC (I).BZJJYBZ,
                         TB_EAST_ZJJYXXB_REC (I).GLBZJZH,
                         TB_EAST_ZJJYXXB_REC (I).GLYWBH,
                         TB_EAST_ZJJYXXB_REC (I).WBGLXTMC,
                         TB_EAST_ZJJYXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   -----------------------EAST_ZJJYXXB---资金交易信息表-END-------------------

   ----------------- -----EAST_ZZHJQKMB---总账会计全科目表START-----57---------------
   ELSIF P_TBNAME = 'EAST_ZZHJQKMB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_ZZHJQKMB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_ZZHJQKMB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_ZZHJQKMB_TMP
          WHERE     NBJGH = TB_EAST_ZZHJQKMB_REC (I).NBJGH
                AND KMBH = TB_EAST_ZZHJQKMB_REC (I).KMBH
                AND BZ = TB_EAST_ZZHJQKMB_REC (I).BZ
                AND KJRQ = TB_EAST_ZZHJQKMB_REC (I).KJRQ
                AND BSZQ = TB_EAST_ZZHJQKMB_REC (I).BSZQ; -- (NBJGH, KMBH, BZ, KJRQ, BSZQ)

         IF V_CNT > 0
         THEN
            UPDATE EAST_ZZHJQKMB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE     NBJGH = TB_EAST_ZZHJQKMB_REC (I).NBJGH
                   AND KMBH = TB_EAST_ZZHJQKMB_REC (I).KMBH
                   AND BZ = TB_EAST_ZZHJQKMB_REC (I).BZ
                   AND KJRQ = TB_EAST_ZZHJQKMB_REC (I).KJRQ
                   AND BSZQ = TB_EAST_ZZHJQKMB_REC (I).BSZQ; -- (NBJGH, KMBH, BZ, KJRQ, BSZQ)
         ELSE
            INSERT INTO REPORT.EAST_ZZHJQKMB_TMP (JRXKZH,
                                                  YHJGDM,
                                                  NBJGH,
                                                  YHJGMC,
                                                  KMBH,
                                                  KMMC,
                                                  KMJC,
                                                  KMLX,
                                                  QCJFYE,
                                                  QCDFYE,
                                                  JFFSE,
                                                  DFFSE,
                                                  QMJFYE,
                                                  QMDFYE,
                                                  BZ,
                                                  KJRQ,
                                                  BSZQ,
                                                  ERRMSG)
                 VALUES (TB_EAST_ZZHJQKMB_REC (I).JRXKZH,
                         TB_EAST_ZZHJQKMB_REC (I).YHJGDM,
                         TB_EAST_ZZHJQKMB_REC (I).NBJGH,
                         TB_EAST_ZZHJQKMB_REC (I).YHJGMC,
                         TB_EAST_ZZHJQKMB_REC (I).KMBH,
                         TB_EAST_ZZHJQKMB_REC (I).KMMC,
                         TB_EAST_ZZHJQKMB_REC (I).KMJC,
                         TB_EAST_ZZHJQKMB_REC (I).KMLX,
                         TB_EAST_ZZHJQKMB_REC (I).QCJFYE,
                         TB_EAST_ZZHJQKMB_REC (I).QCDFYE,
                         TB_EAST_ZZHJQKMB_REC (I).JFFSE,
                         TB_EAST_ZZHJQKMB_REC (I).DFFSE,
                         TB_EAST_ZZHJQKMB_REC (I).QMJFYE,
                         TB_EAST_ZZHJQKMB_REC (I).QMDFYE,
                         TB_EAST_ZZHJQKMB_REC (I).BZ,
                         TB_EAST_ZZHJQKMB_REC (I).KJRQ,
                         TB_EAST_ZZHJQKMB_REC (I).BSZQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   --------- -----EAST_ZZHJQKMB---总账会计全科目表-END-------------------

   -------------------------------EAST_JGXXB---机构信息表58---START----58----------------
   ELSIF P_TBNAME = 'EAST_JGXXB'
   THEN
      FETCH CUR_TMP
         BULK COLLECT INTO TB_EAST_JGXXB_REC
         LIMIT V_LIMT;

      FOR I IN 1 .. TB_EAST_JGXXB_REC.COUNT
      LOOP
         SELECT COUNT (*)
           INTO V_CNT
           FROM EAST_JGXXB_TMP
          WHERE NBJGH = TB_EAST_JGXXB_REC (I).NBJGH;                 --(NBJGH)

         IF V_CNT > 0
         THEN
            UPDATE EAST_JGXXB_TMP
               SET ERRMSG = ERRMSG || ';' || P_ERRMSG
             WHERE NBJGH = TB_EAST_JGXXB_REC (I).NBJGH;              --(NBJGH)
         ELSE
            INSERT INTO REPORT.EAST_JGXXB_TMP (YXJGDM,
                                               NBJGH,
                                               JRXKZH,
                                               YXJGMC,
                                               JGLB,
                                               YZBM,
                                               WDH,
                                               YYZT,
                                               CLSJ,
                                               JGGZKSSJ,
                                               JGGZZZSJ,
                                               JGDZ,
                                               FZRXM,
                                               FZRZW,
                                               FZRLXDH,
                                               CJRQ,
                                               ERRMSG)
                 VALUES (TB_EAST_JGXXB_REC (I).YXJGDM,
                         TB_EAST_JGXXB_REC (I).NBJGH,
                         TB_EAST_JGXXB_REC (I).JRXKZH,
                         TB_EAST_JGXXB_REC (I).YXJGMC,
                         TB_EAST_JGXXB_REC (I).JGLB,
                         TB_EAST_JGXXB_REC (I).YZBM,
                         TB_EAST_JGXXB_REC (I).WDH,
                         TB_EAST_JGXXB_REC (I).YYZT,
                         TB_EAST_JGXXB_REC (I).CLSJ,
                         TB_EAST_JGXXB_REC (I).JGGZKSSJ,
                         TB_EAST_JGXXB_REC (I).JGGZZZSJ,
                         TB_EAST_JGXXB_REC (I).JGDZ,
                         TB_EAST_JGXXB_REC (I).FZRXM,
                         TB_EAST_JGXXB_REC (I).FZRZW,
                         TB_EAST_JGXXB_REC (I).FZRLXDH,
                         TB_EAST_JGXXB_REC (I).CJRQ,
                         P_ERRMSG);
         END IF;
      END LOOP;

      COMMIT;
   ---------------------------EAST_JGXXB---机构信息表58-END-------------------
   ELSE
      NULL;
   END IF;
   EXCEPTION
   when others then
   DBMS_OUTPUT.PUT_LINE('字段检查过程出错,错误原因'||sqlcode||'*****'||sqlerrm);
   DBMS_OUTPUT.PUT_LINE('字段检查过程出错,错误P_SQL语句是'||P_SQL); 
   --增加错误记录说明 
   V_EXCEMSG := '错误P_SQL语句是'||P_SQL||'错误原因'||sqlcode||'*****'||sqlerrm;
   UPDATE EAST_PROCESS_LOG set EXCEMSG = EXCEMSG ||';'||V_EXCEMSG;
   COMMIT;
END EAST_MXCL;
/