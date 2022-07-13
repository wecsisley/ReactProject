import imagemDescription from '../../assets/images/image 2.png'
import Header from '../../components/Header'
import Tittle from '../../components/Tittle'
import { SubTittle, Texto } from '../../components/SubTittle/styles'


const Description = () => {
    return (
        <div>
            <Header />
            <Tittle valueText="Etapas de coleta" />
            <SubTittle>Descrição das Etapas de</SubTittle>
            <SubTittle>coletas de dados feitas pela</SubTittle>
            <SubTittle>BioMob</SubTittle>
            <Texto>
            <p>A coleta de dados é um processo utilizado para captar informações geradas pelas</p>
            <p>pessoas (ou por processos) e que servirão de insumos para planejar estratégias</p>
            <p>para o negócio. Esses dados podem ser coletados em plataformas específicas</p>
            <p>para coletas, formulários, sites e outras metodologias.</p> 
            </Texto>
            <img src={imagemDescription} alt="" style={{}}  />
        </div>
    )
}

export default Description ;