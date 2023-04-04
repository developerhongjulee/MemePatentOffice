import NftAuctionCard from "components/common/card/NftAuctionCard";
import { auctionCardType } from "store/auction";

import styles from "./ProfileAuction.module.css";

interface Props {
  auctionList: auctionCardType[];
}

const ProfileAuction: React.FC<Props> = ({ auctionList }) => {
  return (
    <div className={styles.auctionContainer}>
      
      {/*  nft 없는 경우 */}
      {auctionList.length === 0 && <div>진행중인 경매가 없습니다.</div>}

      {auctionList.map((auction) => {
        return <NftAuctionCard key={auction.memeId} items={auction} />;
      })}
    </div>
  );
};

export default ProfileAuction;
