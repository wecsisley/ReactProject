import { SubTittle, texto2 } from "../../components/SubTittle/styles";
import Header from '../../components/Header'
import Tittle from '../../components/Tittle'
import imageMap from '../../assets/images/image 28.png'

const Description2 = () => {
    return (
        <div id="divDescription2">
            <Header />
            <Tittle valueText= "Mapas da Coletas" />
            <SubTittle>Descrição dos locais de</SubTittle>
            <SubTittle>coletas de dados feitas pela</SubTittle>
            <SubTittle>BioMob</SubTittle>
            <texto2>
            <p>A BioMob coletou os dados nas seguintes regiões de Petrópolis</p>
            <p>Alto da Serra;</p>
            <p>Quitandinha;</p>
            <p>Vale dos Esquilos;</p>
            </texto2>
            <img src={imageMap} alt="" style={{}}  />
        </div>
    )

}

export default Description2;