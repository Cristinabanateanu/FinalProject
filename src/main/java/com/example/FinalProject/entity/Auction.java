package com.example.FinalProject.entity;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Auctions")
public class Auction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    private AuctionCategory category;
    @Column(name = "minimumAmount")
    private Double minAmount;
    @Column(name = "buyItNowAmount")
    private Double binAmount;
    @Column(name = "promoted")
    private Boolean promoted;
    @Column(name = "location")
    private String location;
    @CreationTimestamp
    private LocalDateTime dateOfIssue;
    @Timestamp
    private LocalDateTime endDate;
    @Column(name = "numberOfVisitors")
    private Integer numberOfVisitors;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "auction", fetch = FetchType
            .LAZY, orphanRemoval = true)
    private List<Bidding> auctionBiddings;
    @OneToOne(mappedBy = "auction")
    private Purchase purchase;
    public boolean isExpired(){
        return endDate.
                isBefore(LocalDateTime.now());
    }

    public boolean isPurchased(){
        return purchase != null;
    }

    public void addBidding(Bidding bidding) {
        this.auctionBiddings.add(bidding);
    }
}
