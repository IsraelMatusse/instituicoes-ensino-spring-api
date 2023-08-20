package com.escolasapiapi.db;

import com.escolasapiapi.services.ProvinciaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class DataBaseInitilizer implements CommandLineRunner {
  @PersistenceContext
    private EntityManager entityManager;

    private final ProvinciaService provinciaService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
    if(!provinciaService.existemProvincias()){

        String sqlZonasRegionais = "INSERT INTO `zona_regional` (`id`, `codigo`, `designacao`, `sigla`)\n" +
                "VALUES\n" +
                "    (1, '1', 'Zona norte', 'zn'),\n" +
                "    (2, '2', 'Zona centro', 'zc'),\n" +
                "    (3, '3', 'Zona Sul', 'zs');";
        entityManager.createNativeQuery(sqlZonasRegionais).executeUpdate();


        String sqlQueryProvincias="INSERT INTO `provincia` (`id`, `codigo`, `designacao`, `sigla`, `zona_regional_id`)\n" +
                "VALUES\n" +
                "    (1, '1', 'Niassa', 'NIA', 1),\n" +
                "    (2, '2', 'Cabo Delgado', 'CDL', 1),\n" +
                "    (3, '3', 'Nampula', 'NPL', 1),\n" +
                "    (4, '4', 'Zambezia', 'ZAM', 2),\n" +
                "    (5, '5', 'Tete', 'TET', 2),\n" +
                "    (6, '6', 'Manica', 'MAN', 2),\n" +
                "    (7, '7', 'Sofala', 'SOF', 2),\n" +
                "    (8, '8', 'Inhambane', 'INH', 3),\n" +
                "    (9, '9', 'Gaza', 'GZA', 3),\n" +
                "    (10, '10', 'Maputo Provincia', 'MPT', 3),\n" +
                "    (11, '11', 'Maputo Cidade', 'MPC', 3);";
        entityManager.createNativeQuery(sqlQueryProvincias).executeUpdate();


        String sqlQueryNiveisEnsino="INSERT INTO `nivel_ensino` (`id`, `codigo`, `designacao`)" +
                "VALUES (1, 1, 'Primairio'), " +
                "(2, 2,'Secundario' )," +
                "(3, 3,'Tecnico-Medio' )," +
                "(4, 4, 'Superior');";
        entityManager.createNativeQuery(sqlQueryNiveisEnsino).executeUpdate();


        String sqlQueryInstituicoesEnsino= "INSERT INTO instituicao_ensino (`id`, `codigo`, `designacao`,`sigla`,`provincia_id` , `nivel_ensino_id` )" +
                "VALUES (1, '52A002341', 'UNIVERSIDADE EDUARDO MONDLANE', '1', 1, 4),\n" +
                "    (2, '52A002441', 'UNIVERSIDADE PEDAGOGICA DE MAPUTO', '=1+K1', 1, 4),\n" +
                "    (3, '52A003041', 'UNIVERSIDADE LÃšRIO', '=1+K2', 1, 4),\n" +
                "    (4, '52A003441', 'UNIVERSIDADE ZAMBEZE', '=1+K3', 2, 4),\n" +
                "    (5, '52A004241', 'UNIVERSIDADE JOAQUIM CHISSANO', '=1+K4', 2, 4),\n" +
                "    (6, '52A004341', 'UNIVERSIDADE LICUNGO', '=1+K5', 2, 4),\n" +
                "    (7, '52A004441', 'UNIVERSIDADE PÃšNGUÃ‰', '=1+K6', 2, 4),\n" +
                "    (8, '52A004541', 'UNIVERSIDADE ROVUMA', '=1+K7', 3, 4),\n" +
                "    (9, '52A004641', 'UNIVERSIDADE SAVE', '=1+K8', 3, 4),\n" +
                "    (10, '52B000641', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE NIASSA', '=1+K9', 1, 4),\n" +
                "    (11, '52C000741', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE CABO DELGADO', '=1+K10', 2, 4),\n" +
                "    (12, '52D000841', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE NAMPULA', '=1+K11', 3, 4),\n" +
                "    (13, '52E000741', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE QUELIMANE', '=1+K12', 4, 4),\n" +
                "    (14, '52F000641', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE TETE', '=1+K13', 5, 4),\n" +
                "    (15, '52G000641', 'DELEGACAO DA UNIVERSIDADE PEDAGÃ“GICA DE MANICA', '=1+K14', 6, 4),\n" +
                "    (16, '52H000741', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DA BEIRA', '=1+K15', 7, 4),\n" +
                "    (17, '52I000641', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE MASSINGA', '=1+K16', 8, 4),\n" +
                "    (18, '52I000741', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DA MAXIXE', '=1+K17', 8, 4),\n" +
                "    (19, '52J000841', 'DELEGACAO DA UNIVERSIDADE PEDAGOGICA DE GAZA', '=1+K18', 9, 4),\n" +
                "    (20, '02A001441', 'INSTITUTO DE COMUNICACCAO SOCIAL', '=1+K19', 3, 3),\n" +
                "    (21, '04G546341', 'INSTITUTO MEDIO POLITECNICO ARMANDO EMILIO GUEBUZA CHIGODOLE', '=1+K20', 6, 3),\n" +
                "    (22, '15A000441', 'INSTITUTO SUPERIOR DE ESTUDOS DE DEFESA', '=1+K21', 11, 3),\n" +
                "   (23, '25A001441', 'INSTITUTO DE FORMACAO EM ADMINISTRACAO PUBLICA E AUTARQUICA', '=1+K22', 11, 3),\n" +
                "   (24, '25A002441', 'INSTITUTO SUPERIOR DE ADMINISTRACAO PUBLICA', '=1+K23', 11, 3),\n" +
                "   (25, '25B001041', 'INSTITUTO DE FORMAÇÃO EM ADMINISTRAÇÃO PÚBLICA E AUTÁRQUICQ( IFAPA )-LICHINGA', '=1+K24', 11, 3),\n" +
                "(26, '25H001041', 'INSTITUTO DE FORMACAO EM ADMINISTRACAO PUBLICA E AUTARQUICA DE SOFALA', '=1+K25', 7, 3),\n" +
                "(27, '25K001041', 'INSTITUTO DE FORMAÇÃO EM ADMINISTRAÇÃO PUBLICA AUTARTICA MAPUTO', '=1+K26', 10, 3),\n" +
                "(28, '31A001041', 'INSTITUTO DE FORMACAO PROFISSIONAL E ESTUDOS LABORAIS - ALBERTO CASSIMO', '=1+K27', 11, 3),\n" +
                "(29, '31B000641', 'INSTITUTO DE FORMACAO PROFISSIONAL E ESTUDOS LABOARAIS ALBERTO CASSIMO', '=1+K28', 1, 3),\n" +
                "(30, '31C000641', 'INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO-CABO DELGADO', '=1+K29', 2, 3),\n" +
                "(31, '31D000641', 'INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO DE NAMPULA', '=1+K30', 3, 3),\n" +
                "(32, '31D001541', 'INSTITUTO NACIONAL DE EMPREGO INEP DE NAMPULA', '=1+K31', 3, 3),\n" +
                "(33, '31E000641', 'INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO-ZAMBÉZIA', '=1+K32', 4, 3),\n" +
                "(34, '31E001541', 'INSTITUTO NACIONAL DO EMPREGO', '=1+K33', 4, 3),\n" +
                "(35, '31H000641', 'INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO', '=1+K34', 7, 3),\n" +
                "(36, '31H001541', 'INSTITUTO NACIONAL DE EMPREGO DELEGACAO PROVINCIAL DE SOFALA', '=1+K35', 7, 3),\n" +
                "(37, '31I000641', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO DE INHAMBANE', '=1+K36', 8, 3),\n" +
                "(38, '31K000641', 'DELEGAÇÃO INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO DA PROVINCIA DE MAPUTO IFPELAC', '=1+K37', 10, 3),\n" +
                "(39, '31K001541', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO NACIONAL, INSTITUTO PÚBLICO INEP,IP', '=1+K38', 10, 3),\n" +
                "(40, '31L000641', 'IFPELAC - INSTITUTO DE FORMAÇÃO PROFISSIONAL E ESTUDOS LABORAIS ALBERTO CASSIMO', '=1+K39', 11, 3),\n" +
                "(41, '33A001141', 'INSTITUTO MEDIO DE PLANEAMENTO FISICO E AMBIENTE', '=1+K40', 11, 3),\n" +
                "(42, '33A002641', 'INSTITUTO DE FORMAÇÃO EM ADMINISTRACAO DE TERRAS E CARTOGRAFIA', '=1+K41', 11, 3),\n" +
                "(43, '35A001641', 'INSTITUTO DE ALGODÃO E OLEAGINOSAS DE MOÇAMBIQUE - IAOM', '=1+K42', 11, 3),\n" +
                "(44, '35A002141', 'INSTITUTO DE AMENDOAS DE MOÇAMBIQUE, IP', '=1+K43', 11, 3),\n" +
                "(45, '35A003441', 'INSTITUTO NACIONAL DO ACUCAR DE MOCAMBIQUE', '=1+K44', 11, 4),\n" +
                "(46, '35A003641', 'INSTITUTO DE INVESTIGACAO AGRARIA DE MOCAMBIQUE', '=1+K45', 1, 3),\n" +
                "(47, '35A005041', 'INSTITUTO NACIONAL DE IRRIGACAO', '=1+K46', 1, 3),\n" +
                "(48, '35D002041', 'INSTITUTO DE FOMENTO DO CAJU DE NAMPULA', '=1+K47', 3, 3),\n" +
                "(49, '35E002041', 'INSTITUTO DE AMÃŠNDOAS DE MOÃ‡AMBIQUE I P', '=1+K48', 4, 3),\n" +
                "(50, '37A000941', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DE PESCA PEQUENA ESCALA', '=1+K49', 11, 3),\n" +
                "(51, '37A001041', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DA AQUACULTURA', '=1+K50', 11, 3),\n" +
                "(52, '37A001141', 'INSTITUTO NACIONAL DE INSPECCAO DO PESCADO', '=1+K51', 11, 3),\n" +
                "(53, '37A001241', 'INSTITUTO NACIONAL DE INVESTIGACÃO PESQUEIRA', '=1+K52', 11, 3),\n" +
                "(54, '37A002041', 'INSTITUTO DE DESENVOLVIMENTO DE PESCA PEQUENA ESCALA - PROPESCA', '=1+K53', 11, 3),\n" +
                "(55, '37A002341', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DA PESCA E AQUACULTURA', '=1+K54', 11, 3),\n" +
                "(56, '37A002441', 'INSTITUTO DE DESENVOLVIMENTO DA PESCA E AQUACULTURA-PROPESCA', '=1+K55', 11, 3),\n" +
                "(57, '37A002641', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO E GESTAO DE INFRA ESTRUTURAS PESQUEIRAS', '=1+K56', 11, 3),\n" +
                "(58, '37A002741', 'INSTITUTO OCEANOGRAFICO DE MOCAMBIQUE', '=1+K57', 11, 3),\n" +
                "(59, '37A002841', 'INSTITUTO NACIONAL DO MAR, IP', '=1+K58', 11, 3),\n" +
                "(60, '37B000341', 'DELEGACÃO DO INSTITUTO NACIONAL DE DESENVOLVIMENTO DA AQUACULTURA DE NIASSA', '=1+K59', 11, 3),\n" +
                "(61, '37B000541', 'INSTITUTO NACIONAL DE INVESTIGACAO PESQUEIRA DELEGACAO DO NIASSA', '=1+K60', 1, 3),\n" +
                "(62, '37F000441', 'INSTITUTO NACIONAL INSPECÃO PESCADO - TETE', '=1+K61', 5, 3),\n" +
                "(63, '37F000941', 'INSTITUTO NAC. DE DESEN.DA PESCA E AQUACULTURA', '=1+K62', 5, 3),\n" +
                "(64, '37I000541', 'DELEGACÃO PROVINCIAL DO INSTITUTO NACIONAL DE INVESTIGACAO PESQUEIRA DE INHAMBANE', '=1+K63', 8, 3),\n" +
                "(65, '37I000841', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DA PESCA E AQUACULTURA - DELEGAÃ‡ÃƒO DE INHAMBANE', '=1+K64', 8, 3),\n" +
                "(66, '37J000241', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO NACIONAL DE DESENVOLVIMENTO DA PESCA DE PEQUENA ESCALA DE GAZA', '=1+K65', 9, 3),\n" +
                "(67, '37J000541', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO NACIONAL DE INVESTIGAÇÃO PESQUEIRA EM GAZA', '=1+K66', 9, 3),\n" +
                "(68, '37J000841', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DA PESCA E AQUACULTURA DELEGAÇÃO DE GAZA', '=1+K67', 9, 3),\n" +
                "(69, '37K000241', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO DE DESENVOLVIMENTO DE PESCA PEQUENA ESCALA DE MAPUTO', '=1+K68', 10, 3),\n" +
                "(70, '37K000441', 'DELEGAÇÃO DO INSTITUTO NACIONAL DE INSPEÇÃO DO PESCADO DE MAPUTO PROVINCIA', '=1+K69', 10, 3),\n" +
                "(71, '37K000541', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO NACIONAL DE INVESTIGAÇÃO PESQUEIRA EM MAPUTO - UGB', '=1+K70', 10, 3),\n" +
                "(72, '37K000741', 'INSTITUTO NACIONAL DE DESENVOLVIMENTO DA PESCA E AQUACULTURA DELEGAÇÃO DE MAPUTO', '=1+K71', 10, 3),\n" +
                "(73, '39A001341', 'INSTITUTO GEOLOGICO MINEIRO', '=1+K72', 11, 3),\n" +
                "(74, '39A001841', 'INSTITUTO NACIONAL DE PETROLEO', '=1+K73', 10, 3),\n" +
                "(75, '41A001441', 'INSTITUTO DE PROPRIEDADE INDUSTRIAL', '=1+K74', 11, 3),\n" +
                "(76, '41A001741', 'INSTITUTO PARA A PROMOCAO DE EXPORTACOES', '=1+K75', 11, 3),\n" +
                "(77, '41A002041', 'INSTITUTO NACIONAL DE NORMALIZACAO E QUALIDADE', '=1+K76', 10, 3),\n" +
                "(78, '41A002141', 'INSTITUTO PARA PROMOCAO DAS PEQUENAS E MEDIAS EMPRESAS', '=1+K77', 11, 3),\n" +
                "(79, '41A003241', 'INSTITUTO DE CEREAIS DE MOCAMBIQUE', '=1+K78', 11, 3),\n" +
                "(80, '43A000741', 'INSTITUTO NACIONAL DO TURISMO', '=1+K79', 11, 3),\n" +
                "(81, '43A001641', 'INSTITUTO SUPERIOR DE ARTES E CULTURA', '=1+K80', 11, 3),\n" +
                "(82, '43A002041', 'INSTITUTO NACIONAL DE AUDIOVISUAL E CINEMA - INAC', '=1+K81', 11, 3),\n" +
                "(83, '43A002141', 'INSTITUTO NACIONAL DO LIVRO E DO DISCO- INLD', '=1+K82', 11, 3),\n" +
                "(84, '43A002341', 'ARPAC- INSTITUTO DE INVESTIGAÇÃO SOCIO- CULTURAL', '=1+K83', 11, 3),\n" +
                "(85, '43A003241', 'INSTITUTO NACIONAL DAS INDÚSTRIAS CULTURAIS E CRIATIVAS', '=1+K84', 11, 3),\n" +
                "(86, '50A001641', 'INSTITUTO DE LINGUAS', '=1+K85', 11, 3),\n" +
                "(87, '50A002241', 'INSTITUTO NACIONAL DE EDUCACAO A DISTANCIA', '=1+K86', 10, 3),\n" +
                "(88, '50A002341', 'INSTITUTO DE BOLSAS DE ESTUDO', '=1+K87', 11, 3),\n" +
                "(89, '50A003341', 'INSTITUTO MÉDIO DE CIÊNCIAS DOCUMENTAIS', '=1+K88', 11, 3),\n" +
                "(90, '50A006041', 'IEDA INSTITUTO DE EDUCACAO ABERTA E A DISTANCIA', '=1+K89', 10, 3),\n" +
                "(91, '50A006141', 'INSTITUTO NACIONAL DE EXAMES CERTIFICACAO E EQUIVALENCIAS', '=1+K90', 11, 3),\n" +
                "(92, '52A001641', 'INSTITUTO NACIONAL DE TECNOLOGIAS DE INFORMAÇÃO E COMUNICAÇÃO I.P', '=1+K91', 11, 3),\n" +
                "(93, '52A001841', 'INSTITUTO DE INVESTIGACAO EM AGUAS', '=1+K92', 11, 3),\n" +
                "(94, '52A002241', 'INSTITUTO SUPERIOR DE CIENCIAS DE SAUDE', '=1+K93', 11, 3),\n" +
                "(95, '52A002541', 'INSTITUTO SUPERIOR DE RELACOES INTERNACIONAIS', '=1+K94', 10, 4),\n" +
                "(96, '52A002641', 'INSTITUTO SUPERIOR DE CONTABILIDADE E AUDITORIA DE MOCAMBIQUE', '=1+K95', 11, 4),\n" +
                "(97, '52A003141', 'INSTITUTO SUPERIOR POLITECNICO DE SONGO', '=1+K96', 5, 4),\n" +
                "(98, '52A004041', 'INSTITUTO NACIONAL DE GOVERNO ELETRONICO', '=1+K97', 11, 3),\n" +
                "(99, '52F000841', 'INSTITUTO SUPERIOR POLITECNICO DE TETE', '=1+K98', 5, 4),\n" +
                "(100, '52F000941', 'INSTITUTO NACIONAL DE GOVERNO ELECTRÓNICO DELEGAÇÃO DE MANICA', '=1+K99', 5, 3),\n" +
                "(101, '52G000741', 'INSTITUTO SUPERIOR POLITECNICO DE MANICA', '=1+K100', 6, 3),\n" +
                "(102, '52J000741', 'INSTITUTO SUPERIOR POLITÉCNICO DE GAZA', '=1+K101', 9, 3),\n" +
                "(103, '54A001041', 'INSTITUTO NACIONAL DA JUVENTUDE', '=1+K102', 11, 3),\n" +
                "(104, '54A001241', 'INSTITUTO NACIONAL DO DESPORTO', '=1+K103', 11, 3),\n" +
                "(105, '58A001441', 'INSTITUTO DE CIENCIAS DE SAUDE DE MAPUTO', '=1+K104', 11, 3),\n" +
                "(106, '58A003041', 'INSTITUTO NACIONAL DE SAUDE', '=1+K105', 10, 3),\n" +
                "(107, '58D008241', 'DELEGAÇÃO PROVINCIAL DO INSTITUTO NACIONAL DE SAUDE', '=1+K106', 3, 3),\n" +
                "(108, '58E002441', 'INSTITUTO DE CIÊNCIAS DE SAÚDE DE QUELIMANE', '=1+K107', 4, 3),\n" +
                "(109, '58G003641', 'INSTITUTO DE CIENCIAS DE SAUDE DE MANICA', '=1+K108', 6, 3),\n" +
                "(110, '58H003241', 'DELEGAÇÃO PROVINCIAL DE SOFALA DO INSTITUTO NACIONAL DE SAUDE', '=1+K109', 7, 3),\n" +
                "(111, '58L007041', 'INSTITUTO DE CIENCIAS DE SAUDE DO INFULENE', '=1+K110', 11, 3),\n" +
                "(112, '58L007141', 'INSTITUTO NACIONAL DE SAUDE DELEGAÇÃO DA CIDADE DE MAPUTO', '=1+K111', 11, 3),\n" +
                "(113, '60A000841', 'INSTITUTO DE PESQUISA DA HISTORIA DA LUTA DE LIBERTACAO NACIONAL', '=1+K112', 11, 3),\n" +
                "(114, '62A000841', 'INAS- INSTITUTO NACIONAL DE AÇÃO SOCIAL', '=1+K113', 11, 3),\n" +
                "(115, '62A001441', 'INSTITUTO DE DIFICIENTES VISUAIS DA BEIRA', '=1+K114', 7, 3);";

                entityManager.createNativeQuery(sqlQueryInstituicoesEnsino).executeUpdate();

    }


}



}
