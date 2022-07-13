import Header from "../../components/Header";
import Tittle from "../../components/Tittle";
import { MainContainer } from './../../components/MainContainer/styles';

export const Home = () => {
    return (
        <MainContainer>
            <Header />
            <Tittle valueText="Painel da Diversidade Funcional" />
        </MainContainer>
    )
};