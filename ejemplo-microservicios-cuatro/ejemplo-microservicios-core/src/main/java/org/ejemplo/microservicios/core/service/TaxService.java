package org.ejemplo.microservicios.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.ejemplo.microservicios.core.dto.OrderDto;

/**
 * Created by jorge.sanchez on 12/06/2018.
 */
@FunctionalInterface
public interface TaxService {

    public static final String SPAIN = "ES";
    public static final String UK = "UK";
    public static final String USA = "USA";

    public static final Double SPAIN_TAXES = 1.21;
    public static final Double UK_TAXES = 1.16;
    public static final Double TRUMP_TAXES = 1.10;

    public double calculateTaxes(double price);

    /*
     * 
     * 
     * Method to get total expenses.
     * 
     */
    public default Optional<Double> calculateExpensesWithoutTaxes(List<OrderDto> orders){
        Optional<Double> expenses =orders.stream()
        		.map((order) -> order.getPrice())
                .reduce((price, priceDos) -> {
                	return price + priceDos;
                });
        return expenses;
    }

    /**
     *
     * Get taxes of one country.
     *
     * @param country
     * @return
     */
    public static Double getTaxesByCountry(String country){
        Double result = SPAIN_TAXES;
        switch(country){
            case UK:
                result = UK_TAXES;
                break;
            case USA:
                result = TRUMP_TAXES;
                break;
        }
        return result;
    }

    /**
     *
     * Get taxes of every country.
     *
     * @return
     */
    public static Map<String, Double> getAllTaxes(){
        Map<String, Double> taxes = new HashMap<String, Double>();
        taxes.put(SPAIN, SPAIN_TAXES);
        taxes.put(UK, UK_TAXES);
        taxes.put(USA, TRUMP_TAXES);
        return taxes;
    }

}
