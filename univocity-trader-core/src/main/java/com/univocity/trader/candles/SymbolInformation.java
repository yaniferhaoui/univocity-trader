package com.univocity.trader.candles;

import java.math.*;

public final class SymbolInformation {

	public static double DEFAULT_MINIMUM_ASSETS_PER_ORDER_AMOUNT = 0.000001;// not zero to prevent trades that would use pennies.
	public static BigDecimal DEFAULT_MINIMUM_ASSETS_PER_ORDER = BigDecimal.valueOf(0.000001);// not zero to prevent trades that would use pennies.

	private final String symbol;
	private int priceDecimalPlaces = 2;
	private int quantityDecimalPlaces = 0;
	private BigDecimal minimumAssetsPerOrder = DEFAULT_MINIMUM_ASSETS_PER_ORDER;
	private double minimumAssetsPerOrderAmount = -1.0;
	private BigDecimal minimumQtyPerOrder = DEFAULT_MINIMUM_ASSETS_PER_ORDER;
	private double minimumQtyPerOrderAmount = -1.0;

	public SymbolInformation(String symbol) {
		this.symbol = symbol;
	}

	public String symbol() {
		return symbol;
	}

	public int priceDecimalPlaces() {
		return priceDecimalPlaces;
	}

	public SymbolInformation priceDecimalPlaces(int priceDecimalPlaces) {
		this.priceDecimalPlaces = priceDecimalPlaces;
		return this;
	}

	public int quantityDecimalPlaces() {
		return quantityDecimalPlaces;
	}

	public SymbolInformation quantityDecimalPlaces(int quantityDecimalPlaces) {
		this.quantityDecimalPlaces = quantityDecimalPlaces;
		return this;
	}

	public BigDecimal minimumAssetsPerOrder() {
		return minimumAssetsPerOrder;
	}

	public double minimumAssetsPerOrderAmount() {
		if (minimumAssetsPerOrderAmount < 0.0) {
			minimumAssetsPerOrderAmount = minimumAssetsPerOrder.doubleValue();
		}
		return minimumAssetsPerOrderAmount;
	}

	public double minimumQtyPerOrderAmount() {
		if (minimumQtyPerOrderAmount < 0.0) {
			minimumQtyPerOrderAmount = minimumQtyPerOrder.doubleValue();
		}
		return minimumQtyPerOrderAmount;
	}

	public SymbolInformation minimumAssetsPerOrder(double minimumAssetsPerOrder) {
		return minimumAssetsPerOrder(BigDecimal.valueOf(minimumAssetsPerOrder));
	}

	public SymbolInformation minimumAssetsPerOrder(BigDecimal minimumAssetsPerOrder) {
		this.minimumAssetsPerOrder = minimumAssetsPerOrder;
		this.minimumAssetsPerOrderAmount = -1.0;
		return this;
	}

	public SymbolInformation minimumQtyPerOrder(double minimumQtyPerOrder) {
		return minimumQtyPerOrder(BigDecimal.valueOf(minimumQtyPerOrder));
	}

	public SymbolInformation minimumQtyPerOrder(BigDecimal minimumQtyPerOrder) {
		this.minimumQtyPerOrder = minimumQtyPerOrder;
		this.minimumQtyPerOrderAmount = -1.0;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
				"symbol='" + symbol + '\'' +
				", priceDecimalPlaces=" + priceDecimalPlaces +
				", quantityDecimalPlaces=" + quantityDecimalPlaces +
				", minimumAssetsPerOrder=" + minimumAssetsPerOrder +
				", minimumAssetsPerOrderAmount=" + minimumAssetsPerOrderAmount +
				", minimumQtyPerOrderAmount=" + minimumQtyPerOrderAmount +
				'}';
	}
}
