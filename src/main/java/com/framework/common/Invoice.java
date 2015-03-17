package com.framework.common;

import com.framework.app.common.PropertyHelper;

public class Invoice extends Main {
    private DB cust;
    private PropertyHelper propsHelper = new PropertyHelper();

    public Invoice() throws Exception {
        cust = new DB(propsHelper.getENV() + "CUST");
    }

    public String getAcct(String key) throws Exception {
        String invoiceAcct = cust.execSQLSelect(cust.oracleDBStatement(), propsHelper.getSQLInvoiceProperties(key), 1);
        if (invoiceAcct == null || invoiceAcct == "")
            throw new Exception("Empty SQL result");
        System.out.println("Account : " + invoiceAcct);

        return invoiceAcct;
    }

    public String getInvoiceId(String key) throws Exception {
        String invoiceId = cust.execSQLSelect(cust.oracleDBStatement(), propsHelper.getSQLInvoiceProperties(key), 2);
        if (invoiceId == null || invoiceId == "")
            throw new Exception("Empty SQL result");
        System.out.println("Invoice : " + invoiceId);
        return invoiceId;
    }
}
