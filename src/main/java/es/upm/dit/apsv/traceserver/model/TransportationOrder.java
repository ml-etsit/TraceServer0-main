package es.upm.dit.apsv.traceserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString

public class TransportationOrder {  
    private String toid;
    @Id
    private String truck;
    private long originDate;
    private double originLat;
    private double originLong;
    private long dstDate;
    private double dstLat;
    private double dstLong;
    private long lastDate;
    private double lastLat;
    private double lastLong;
    private int st;


    public TransportationOrder(String toid, String truck, long originDate,
                               double originLat, double originLong,
                               long dstDate, double dstLat, double dstLong,
                               long lastDate, double lastLat, double lastLong,
                               int st) { 

                            this.toid = toid;
                            this.truck = truck;
                            this.originDate = originDate;
                            this.originLat = originLat;
                            this.originLong = originLong;
                            this.dstDate = dstDate;
                            this.dstLat = dstLat;
                            this.dstLong = dstLong;
                            this.lastDate = lastDate;
                            this.lastLat = lastLat;
                            this.lastLong = lastLong;
                            this.st = st;

                                }

    public double distanceToDestination() {

        return Math.sqrt(Math.pow(this.dstLat -this.lastLat, 2)
                    + Math.pow(this.dstLong - this.lastLong, 2));

    }
}