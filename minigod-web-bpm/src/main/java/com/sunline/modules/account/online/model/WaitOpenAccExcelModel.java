package com.sunline.modules.account.online.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @description: 待开户信息导出（导出后手动导入到ayers柜台开户）
 * @author: Tim
 * @date: 2020/07/26
 */
@Data
public class WaitOpenAccExcelModel extends BaseRowModel {
    @ExcelProperty(value = "ID" ,index = 0)
    private String id;

    @ExcelProperty(value = "LACCT" ,index = 1)
    private String lacct;

    @ExcelProperty(value = "LNAME" ,index = 2)
    private String lname;

    @ExcelProperty(value = "LNAME2" ,index = 3)
    private String lname2;

    @ExcelProperty(value = "LADDR1" ,index = 4)
    private String laddr1;

    @ExcelProperty(value = "LADDR2" ,index = 5)
    private String laddr2;

    @ExcelProperty(value = "LADDR3" ,index = 6)
    private String LADDR3;

    @ExcelProperty(value = "LCODE" ,index = 7)
    private String LCODE;

    @ExcelProperty(value = "LICODE" ,index = 8)
    private String LICODE;

    @ExcelProperty(value = "LRNER" ,index = 9)
    private String LRNER;

    @ExcelProperty(value = "LTEL" ,index = 10)
    private String LTEL;

    @ExcelProperty(value = "LIDNO" ,index = 11)
    private String LIDNO;

    @ExcelProperty(value = "LMGN" ,index = 12)
    private String LMGN;

    @ExcelProperty(value = "LBALBF" ,index = 13)
    private String LBALBF;

    @ExcelProperty(value = "LBALMTD" ,index = 14)
    private String LBALMTD;

    @ExcelProperty(value = "LCURBS" ,index = 15)
    private String LCURBS;

    @ExcelProperty(value = "LCURPR" ,index = 16)
    private String LCURPR;

    @ExcelProperty(value = "LLMT" ,index = 17)
    private String LLMT;

    @ExcelProperty(value = "LINTMTD" ,index = 18)
    private String LINTMTD;

    @ExcelProperty(value = "LINTNXT" ,index = 19)
    private String LINTNXT;

    @ExcelProperty(value = "LIDATE" ,index = 20)
    private String LIDATE;

    @ExcelProperty(value = "LTRADE" ,index = 21)
    private String LTRADE;

    @ExcelProperty(value = "LPTRADE" ,index = 22)
    private String LPTRADE;

    @ExcelProperty(value = "LDIVCHQ" ,index = 23)
    private String LDIVCHQ;

    @ExcelProperty(value = "LBALMTLD" ,index = 24)
    private String LBALMTLD;

    @ExcelProperty(value = "LCRDATE" ,index = 25)
    private String LCRDATE;

    @ExcelProperty(value = "LCQPRINT" ,index = 26)
    private String LCQPRINT;

    @ExcelProperty(value = "LCYTRADE" ,index = 27)
    private String LCYTRADE;

    @ExcelProperty(value = "LPYTRADE" ,index = 28)
    private String LPYTRADE;

    @ExcelProperty(value = "LCOMAMT" ,index = 29)
    private String LCOMAMT;

    @ExcelProperty(value = "LCYCOMM" ,index = 30)
    private String LCYCOMM;

    @ExcelProperty(value = "LPLABEL" ,index = 31)
    private String LPLABEL;

    @ExcelProperty(value = "LCCASS" ,index = 32)
    private String LCCASS;

    @ExcelProperty(value = "LBANK" ,index = 33)
    private String LBANK;

    @ExcelProperty(value = "LBKAC" ,index = 34)
    private String LBKAC;

    @ExcelProperty(value = "LOFFTEL" ,index = 35)
    private String LOFFTEL;

    @ExcelProperty(value = "LSTMDATE" ,index = 36)
    private String LSTMDATE;

    @ExcelProperty(value = "LACTDATE" ,index = 37)
    private String LACTDATE;

    @ExcelProperty(value = "LTRUST" ,index = 38)
    private String LTRUST;

    @ExcelProperty(value = "LCR1DAY" ,index = 39)
    private String LCR1DAY;

    @ExcelProperty(value = "LCR2DAY" ,index = 40)
    private String LCR2DAY;

    @ExcelProperty(value = "LCR3DAY" ,index = 41)
    private String LCR3DAY;

    @ExcelProperty(value = "LTRINOUT" ,index = 42)
    private String LTRINOUT;

    @ExcelProperty(value = "LINTPEN" ,index = 43)
    private String LINTPEN;

    @ExcelProperty(value = "LINTPENX" ,index = 44)
    private String LINTPENX;

    @ExcelProperty(value = "LCURIN" ,index = 45)
    private String LCURIN;

    @ExcelProperty(value = "LFOOTNOTE" ,index = 46)
    private String LFOOTNOTE;

    @ExcelProperty(value = "LNOCOM" ,index = 47)
    private String LNOCOM;

    @ExcelProperty(value = "LSEGAC" ,index = 48)
    private String LSEGAC;

    @ExcelProperty(value = "LRNEWDATE" ,index = 49)
    private String LRNEWDATE;

    @ExcelProperty(value = "LSBFPOST" ,index = 50)
    private String LSBFPOST;

    @ExcelProperty(value = "LSTATUS" ,index = 51)
    private String LSTATUS;

    @ExcelProperty(value = "LEMAIL" ,index = 52)
    private String LEMAIL;

    @ExcelProperty(value = "LGEMDATE" ,index = 53)
    private String LGEMDATE;

    @ExcelProperty(value = "LPIN" ,index = 54)
    private String LPIN;

    @ExcelProperty(value = "LPINDATE" ,index = 55)
    private String LPINDATE;

    @ExcelProperty(value = "LFAX" ,index = 56)
    private String LFAX;

    @ExcelProperty(value = "LMOBILE" ,index = 57)
    private String LMOBILE;

    @ExcelProperty(value = "LBALPR" ,index = 58)
    private String LBALPR;

    @ExcelProperty(value = "LPARENT" ,index = 59)
    private String LPARENT;

    @ExcelProperty(value = "LPARENT2" ,index = 60)
    private String LPARENT2;

    @ExcelProperty(value = "LGUARANTE" ,index = 61)
    private String LGUARANTE;

    @ExcelProperty(value = "LBSDATE" ,index = 62)
    private String LBSDATE;

    @ExcelProperty(value = "LUNSTLPR" ,index = 63)
    private String LUNSTLPR;

    @ExcelProperty(value = "LTDRID" ,index = 64)
    private String LTDRID;

    @ExcelProperty(value = "LCASIP" ,index = 65)
    private String LCASIP;

    @ExcelProperty(value = "LVIAINT" ,index = 66)
    private String LVIAINT;

    @ExcelProperty(value = "LVIAPNS" ,index = 67)
    private String LVIAPNS;

    @ExcelProperty(value = "LVIATDR" ,index = 68)
    private String LVIATDR;

    @ExcelProperty(value = "LLANGGE" ,index = 69)
    private String LLANGGE;

    @ExcelProperty(value = "LMOCONT" ,index = 70)
    private String LMOCONT;

    @ExcelProperty(value = "LPAGEOPR" ,index = 71)
    private String LPAGEOPR;

    @ExcelProperty(value = "LNOTIFTN" ,index = 72)
    private String LNOTIFTN;

    @ExcelProperty(value = "LAEIPO" ,index = 73)
    private String LAEIPO;

    @ExcelProperty(value = "LDEFALMT" ,index = 74)
    private String LDEFALMT;

    @ExcelProperty(value = "LGTOLMT" ,index = 75)
    private String LGTOLMT;

    @ExcelProperty(value = "LNTOLMT" ,index = 76)
    private String LNTOLMT;

    @ExcelProperty(value = "LSTRLMT" ,index = 77)
    private String LSTRLMT;

    @ExcelProperty(value = "LDCRLMT" ,index = 78)
    private String LDCRLMT;

    @ExcelProperty(value = "LCANBUY" ,index = 79)
    private String LCANBUY;

    @ExcelProperty(value = "LCANSELL" ,index = 80)
    private String LCANSELL;

    @ExcelProperty(value = "LMGNGP" ,index = 81)
    private String LMGNGP;

    @ExcelProperty(value = "LEMSTMT" ,index = 82)
    private String LEMSTMT;

    @ExcelProperty(value = "LEMAILGP" ,index = 83)
    private String LEMAILGP;

    @ExcelProperty(value = "LPREPR" ,index = 84)
    private String LPREPR;

    @ExcelProperty(value = "LCURRC" ,index = 85)
    private String LCURRC;

    @ExcelProperty(value = "LPARTID" ,index = 86)
    private String LPARTID;

    @ExcelProperty(value = "LPARTBIC" ,index = 87)
    private String LPARTBIC;

    @ExcelProperty(value = "LCTODYAC" ,index = 88)
    private String LCTODYAC;

    @ExcelProperty(value = "LFOP" ,index = 89)
    private String LFOP;

    @ExcelProperty(value = "LCATEGY" ,index =90)
    private String LCATEGY;

    @ExcelProperty(value = "LCCROPT" ,index = 91)
    private String LCCROPT;

    @ExcelProperty(value = "LDAYBS" ,index = 92)
    private String LDAYBS;

    @ExcelProperty(value = "LRNER2" ,index = 93)
    private String LRNER2;

    @ExcelProperty(value = "LHCSTMT" ,index = 94)
    private String LHCSTMT;

    @ExcelProperty(value = "LOCE" ,index = 95)
    private String LOCE;

    @ExcelProperty(value = "LLOC" ,index = 96)
    private String LLOC;

    @ExcelProperty(value = "LCQNAME" ,index = 97)
    private String LCQNAME;

    @ExcelProperty(value = "LCQNAME2" ,index = 98)
    private String LCQNAME2;

    @ExcelProperty(value = "LSHOWTRPQ" ,index = 99)
    private String LSHOWTRPQ;

    @ExcelProperty(value = "LADDR4" ,index = 100)
    private String LADDR4;

    @ExcelProperty(value = "LMGNLMT" ,index = 101)
    private String LMGNLMT;

    @ExcelProperty(value = "LTOINET" ,index = 102)
    private String LTOINET;

    @ExcelProperty(value = "LILMT" ,index = 103)
    private String LILMT;

    @ExcelProperty(value = "LBATCHNO" ,index = 104)
    private String LBATCHNO;

    @ExcelProperty(value = "LRISKALLOW" ,index = 105)
    private String LRISKALLOW;

    @ExcelProperty(value = "LRISKDATE" ,index = 106)
    private String LRISKDATE;

    @ExcelProperty(value = "LFATCA" ,index = 107)
    private String LFATCA;

}
