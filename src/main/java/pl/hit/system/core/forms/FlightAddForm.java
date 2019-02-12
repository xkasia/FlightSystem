package pl.hit.system.core.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class FlightAddForm {

    @NotEmpty(message = "{departureTime.notEmpty}")
    private String departureTime;

    @NotEmpty(message = "{arrivalTime.notEmpty}")
    private String arrivalTime;

    @NotNull(message = "{amountOfSeats.notEmpty}")
    @Min(value = 0, message = ("{amountOfSeats.min}"))
    private Integer amountOfSeats;

    @NotNull(message = "{ticketPrice.notEmpty}")
    @Min(value = 0, message = ("{ticketPrice.min}"))
    private BigDecimal ticketPrice;

    public FlightAddForm() {
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(Integer amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "FlightAddForm{" +
                "departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", amountOfSeats=" + amountOfSeats +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
