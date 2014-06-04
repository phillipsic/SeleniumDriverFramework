package com.comverse.common;

import com.comverse.css.common.PropertyHelper;

public class Invoice extends Main {
    DB cust;
    private PropertyHelper propsHelper = new PropertyHelper();

    public Invoice() throws Exception {
        cust = new DB(propsHelper.getENV() + "CUST");
    }

    public String getAcct(String key) throws Exception {
        String invoiceAcct = cust.execSQL(cust.oracleDBcnx(), propsHelper.getSQLInvoiceProperties(key), 1);
        System.out.println("Account : " + invoiceAcct);
        return invoiceAcct;
    }

    public String getInvoiceId(String key) throws Exception {
        String invoiceAcct = cust.execSQL(cust.oracleDBcnx(), propsHelper.getSQLInvoiceProperties(key), 2);
        System.out.println("Invoice : " + invoiceAcct);
        return invoiceAcct;
    }
}
