package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
 class ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public class ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
