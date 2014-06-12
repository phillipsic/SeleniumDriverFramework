package com.comverse.css.data;

public abstract class Balance extends C1Data {
    private String balanceName;
    private String balanceDescription;
    private String balanceValue;

    public Balance() {
        setBalanceName(null);
        setBalanceDescription(null);
        setBalanceValue(null);
    }

    @Override
	public String getBalanceName() {
        return balanceName;
    }

    public void setBalanceName(String balanceName) {
        this.balanceName = balanceName;
    }

    public String getBalanceDescription() {
        return balanceDescription;
    }

    public void setBalanceDescription(String balanceDescription) {
        this.balanceDescription = balanceDescription;
    }

    @Override
	public String getBalanceValue() {
        return balanceValue;
    }

    public void setBalanceValue(String balanceValue) {
        this.balanceValue = balanceValue;
    }

}
