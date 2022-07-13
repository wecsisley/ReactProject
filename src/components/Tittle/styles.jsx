import styled from "styled-components";
import colors from "../../themes/colors";

export const Container = styled.div`
    border-radius: 20px;
    border: 9px solid ${colors.secondary};
    width: 1073px;
    height: 150px;
    display: flex;
    align-items: center;
    justify-content: center;
    align-self: center;
`
export const Text = styled.div`
    font-size: 60px;
    font-weight: 700px;
    font-family: 'Roboto';
    color: ${colors.primary};
    text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
`