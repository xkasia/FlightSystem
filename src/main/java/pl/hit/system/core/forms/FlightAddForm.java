package pl.hit.system.core.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FlightAddForm {

    @NotEmpty(message = "{departureTime.notEmpty}")
    private String departureTime;

    @NotEmpty(message = "{arrivalTime.notEmpty}")
    private String arrivalTime;

    @NotNull(message = "{amountOfSeats.notEmpty}")
    @Min(value = 0, message = ("{amountOfSeats.min}"))
    Integer amountOfSeats;

    @NotNull(message = "{ticketPrice.notEmpty}")
    @Min(value = 0, message = ("{ticketPrice.min}"))
    Double ticketPrice;

    public FlightAddForm() {
    }

    public Integer getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(Integer amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
