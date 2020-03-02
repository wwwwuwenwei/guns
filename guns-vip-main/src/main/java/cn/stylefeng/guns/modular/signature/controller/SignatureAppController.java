package cn.stylefeng.guns.modular.signature.controller;

import cn.stylefeng.guns.modular.signature.model.params.SignatureParam;
import cn.stylefeng.guns.modular.signature.service.SignatureService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 签名表控制器
 *
 * @author www
 * @Date 2020-02-28 10:12:00
 */
@RestController
@RequestMapping("/signature")
public class SignatureAppController extends BaseController {

    @Autowired
    private SignatureService signatureService;

    /**
     * 更新接口
     * 参数：新增必须传递memberId
     * 更新必须传递id
     * @author www
     * @Date 2020-02-28
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResponseData saveSignature(SignatureParam signatureParam) {
        try {
            //是否存在签名
            if(this.signatureService.isExistSign(signatureParam.getMemberId())){
                //存在,必须要有id
                this.signatureService.update(signatureParam);
            }else {
                //不存在
                this.signatureService.add(signatureParam);
            }
        } catch (Exception e) {
            return ResponseData.error(e.getMessage());
        }
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     * 参数：memberId
     * @author www
     * @Date 2020-02-28
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detailSignature(@RequestParam String memberId) {
        Map<String, Object> detail = null;
        try {
            detail = this.signatureService.getByMemberId(memberId);
        } catch (Exception e) {
            return ResponseData.error(e.getMessage());
        }
        return ResponseData.success(detail);
    }



}


