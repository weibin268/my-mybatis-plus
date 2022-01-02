package ${package.Service};

import ${package.Mapper}.${table.mapperName};
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
 class ${table.serviceName} : ${superServiceClass}<${table.mapperName}, ${entity}>
<#else>
public class ${table.serviceName} extends ${superServiceClass}<${table.mapperName}, ${entity}> {

}
</#if>
