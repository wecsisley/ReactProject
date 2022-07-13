import { Container } from "./styles.jsx";
import imageLogo from "../../assets/images/logo-biomob-semfundo.png";
import ButtonHeader from "../ButtonHeader/index.jsx";

const Header = () => {
  return (
      <Container>
        <div>
          <img src={imageLogo} alt="logo da Biomob" style={{width: 240, height: 80, margin: 10}} />
        </div>
        <div>
          <ButtonHeader />
        </div>
      </Container>
  );
};

export default Header;