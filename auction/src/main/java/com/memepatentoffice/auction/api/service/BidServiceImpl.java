package com.memepatentoffice.auction.api.service;

import com.memepatentoffice.auction.api.request.BidReq;
import com.memepatentoffice.auction.common.exception.BiddingException;
import com.memepatentoffice.auction.common.exception.NotFoundException;
import com.memepatentoffice.auction.common.util.InterServiceCommunicationProvider;
import com.memepatentoffice.auction.db.entity.Bid;
import com.memepatentoffice.auction.db.repository.AuctionRepository;
import com.memepatentoffice.auction.db.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BidServiceImpl implements BidService {

    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;
    private final InterServiceCommunicationProvider isp;
    @Override
    public Long bid(BidReq bidReq) throws NotFoundException, BiddingException {
        if(!auctionRepository.existsById(bidReq.getAuctionId())) throw new NotFoundException("유효하지 않은 auction ID입니다");
        if(!isp.existsUserById(bidReq.getUserId())) throw new NotFoundException("유효하지 않은 판매자 아이디입니다");

        Bid currentTopBid = bidRepository.findTopByOrderByCreatedAtDesc();
        if(!(bidReq.getAskingprice() > currentTopBid.getAskingprice())){
            throw new BiddingException("제안하는 가격이 현재 호가보다 낮아서 안됩니다");
        }

        return bidRepository.save(
            Bid.builder()
                .auctionId(bidReq.getAuctionId())
                .userId(bidReq.getUserId())
                .askingprice(bidReq.getAskingprice()).build()
        ).getId();
    }
}