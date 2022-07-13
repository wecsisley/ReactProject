import { StyledButton } from "./styles.jsx";

const ButtonHeader = () => {

  const handleClick = () => {
    return alert("cliquei");
  };

  return (
    <StyledButton onClick={handleClick}>Entrar</StyledButton>
  );
};

export default ButtonHeader;